private Canvas canvas;
private JAWTDrawingSurface ds;
public long display;
private long eglDisplay;
public long drawable;
private long surface;

public static final JAWT awt;
static {
    awt = JAWT.calloc();
    awt.version(JAWT_VERSION_1_4);
    if (!JAWT_GetAWT(awt))
        throw new AssertionError("GetAWT failed");
}

public void lock() throws AWTException {
    int lock = JAWT_DrawingSurface_Lock(ds, ds.Lock());
    if ((lock & JAWT_LOCK_ERROR) != 0)
        throw new AWTException("JAWT_DrawingSurface_Lock() failed");
}

public void unlock() throws AWTException {
    JAWT_DrawingSurface_Unlock(ds, ds.Unlock());
}

public void Init2()
{
    frame = new JFrame("AWT test");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setLayout(new BorderLayout());
    frame.setPreferredSize(new Dimension(width, height));

    canvas = new Canvas();
    frame.add(canvas);

    frame.pack();
    frame.setVisible(true);
    frame.transferFocus();

    int error;

    System.out.println("Window init2() started");

    this.ds = JAWT_GetDrawingSurface(canvas, awt.GetDrawingSurface());
    //JAWTDrawingSurface ds = JAWT_GetDrawingSurface(canvas, awt.GetDrawingSurface());
    try
    {
        lock();
        try
        {
            JAWTDrawingSurfaceInfo dsi = JAWT_DrawingSurface_GetDrawingSurfaceInfo(ds, ds.GetDrawingSurfaceInfo());

            JAWTX11DrawingSurfaceInfo dsiWin = JAWTX11DrawingSurfaceInfo.create(dsi.platformInfo());

            int depth = dsiWin.depth();
            this.display = dsiWin.display();
            this.drawable = dsiWin.drawable();

            System.out.printf("EGL Display %d, drawable: \n", display, drawable);

            eglDisplay = eglGetDisplay(display);

            EGLCapabilities egl;
            try (MemoryStack stack = stackPush()) {
                IntBuffer major = stack.mallocInt(1);
                IntBuffer minor = stack.mallocInt(1);

                if (!eglInitialize(eglDisplay, major, minor)) {
                    throw new IllegalStateException(String.format("Failed to initialize EGL [0x%X]", eglGetError()));
                }

                egl = EGL.createDisplayCapabilities(eglDisplay, major.get(0), minor.get(0));
            }
            System.out.println("EGL caps created");

            IntBuffer attrib_list = BufferUtils.createIntBuffer(18);
            attrib_list.put(EGL_CONFORMANT).put(EGL_OPENGL_ES2_BIT);
            //attrib_list.put(EGL_ALPHA_MASK_SIZE).put(4);
            //attrib_list.put(EGL_ALPHA_SIZE).put(4);
            //attrib_list.put(EGL_RED_SIZE).put(5);
            //attrib_list.put(EGL_GREEN_SIZE).put(6);
            //attrib_list.put(EGL_BLUE_SIZE).put(5);
            //attrib_list.put(EGL_DEPTH_SIZE).put(4);
            //attrib_list.put(EGL_SURFACE_TYPE).put(EGL_WINDOW_BIT);
            attrib_list.put(EGL_NONE);
            attrib_list.flip();

            PointerBuffer fbConfigs = BufferUtils.createPointerBuffer(1);
            IntBuffer numConfigs = BufferUtils.createIntBuffer(1);

            boolean test2 = eglChooseConfig(eglDisplay, attrib_list, fbConfigs,numConfigs);

            if (fbConfigs == null || fbConfigs.capacity() == 0) {
                // No framebuffer configurations supported!
                System.out.println("No supported framebuffer configurations found");
            }

            long test = numConfigs.get(0);

            IntBuffer context_attrib_list = BufferUtils.createIntBuffer(18);
            context_attrib_list.put(EGL_CONTEXT_MAJOR_VERSION).put(3);
            context_attrib_list.put(EGL_CONTEXT_MINOR_VERSION).put(0);
            context_attrib_list.put(EGL_NONE);
            context_attrib_list.flip();

            long context = eglCreateContext(eglDisplay,fbConfigs.get(0),EGL_NO_CONTEXT,context_attrib_list);

            error = eglGetError();

            surface = eglCreateWindowSurface(eglDisplay,fbConfigs.get(0),drawable,(int[])null);

            error = eglGetError();

            eglMakeCurrent(eglDisplay,surface,surface,context);

            error = eglGetError();

            GLESCapabilities gles = GLES.createCapabilities();
            System.out.println("CLES caps created");
        }
        finally
        {
            unlock();
        }

    }
    catch (Exception e)
    {
        System.out.println("JAWT Failed");
    }

    // Render with OpenGL ES
    glClearColor(0f,0f,0f,1f);
    glfwSwapInterval(vSync);
    glEnable(GL_DEPTH_TEST);

    int[] range = new int[2];
    int[] precision = new int[2];
    glGetShaderPrecisionFormat(GL_FRAGMENT_SHADER, GL_HIGH_FLOAT, range, precision);

    System.out.println("Window context Initialized");
}