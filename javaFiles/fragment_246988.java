public void Init()
{
    System.out.println("Window init() started");

    GLFWErrorCallback.createPrint().set();
    if (!glfwInit()) {
        throw new IllegalStateException("Unable to initialize glfw");
    }

    glfwDefaultWindowHints();
    glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
    glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);

    // GLFW setup for EGL & OpenGL ES
    glfwWindowHint(GLFW_CONTEXT_CREATION_API, GLFW_EGL_CONTEXT_API);
    glfwWindowHint(GLFW_CLIENT_API, GLFW_OPENGL_ES_API);
    glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
    glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 0);

    windowHandle = glfwCreateWindow(width, height, title, NULL, NULL);
    if (windowHandle == NULL) {
        throw new RuntimeException("Failed to create the GLFW window");
    }

    System.out.printf("Window handle created %d\n", windowHandle);

    SetCallbacks();

    // EGL capabilities
    displayHandle = glfwGetEGLDisplay();

    System.out.printf("EGL DisplayHandle %d\n", displayHandle);

    try (MemoryStack stack = stackPush()) {
        IntBuffer major = stack.mallocInt(1);
        IntBuffer minor = stack.mallocInt(1);

        if (!eglInitialize(displayHandle, major, minor)) {
            throw new IllegalStateException(String.format("Failed to initialize EGL [0x%X]", eglGetError()));
        }

        EGLCapabilities egl = EGL.createDisplayCapabilities(displayHandle, major.get(0), minor.get(0));
    }
    System.out.println("EGL caps created");

    // OpenGL ES capabilities
    glfwMakeContextCurrent(windowHandle);
    System.out.printf("Current context: %d.%d rev %d, Client_Context: %d\n",glfwGetWindowAttrib(windowHandle,GLFW_CONTEXT_VERSION_MAJOR),
            glfwGetWindowAttrib(windowHandle,GLFW_CONTEXT_VERSION_MINOR), glfwGetWindowAttrib(windowHandle,GLFW_CONTEXT_REVISION),
            glfwGetWindowAttrib(windowHandle,GLFW_CLIENT_API));

    GLESCapabilities gles = GLES.createCapabilities();
    System.out.println("CLES caps created");

    // Render with OpenGL ES
    //glfwShowWindow(windowHandle);
    glClearColor(0f,0f,0f,1f);
    glfwSwapInterval(vSync);
    glEnable(GL_DEPTH_TEST);

    int[] range = new int[2];
    int[] precision = new int[2];
    glGetShaderPrecisionFormat(GL_FRAGMENT_SHADER, GL_HIGH_FLOAT, range, precision);

    System.out.printf("Current context: %d.%d\n",glfwGetWindowAttrib(windowHandle,GLFW_CONTEXT_VERSION_MAJOR),
                                            glfwGetWindowAttrib(windowHandle,GLFW_CONTEXT_VERSION_MINOR));
}