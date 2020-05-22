/**
     * Initialize the system class.  Called after thread initialization.
     */
    private static void initializeSystemClass() {
    props = new Properties();
    initProperties(props);
    sun.misc.Version.init();

        // Workaround until DownloadManager initialization is revisited.
        // Make JavaLangAccess available early enough for internal
        // Shutdown hooks to be registered
        setJavaLangAccess();

        // Gets and removes system properties that configure the Integer
        // cache used to support the object identity semantics of autoboxing.
        // At this time, the size of the cache may be controlled by the
        // vm option -XX:AutoBoxCacheMax=<size>.
        Integer.getAndRemoveCacheProperties();

    // Load the zip library now in order to keep java.util.zip.ZipFile
    // from trying to use itself to load this library later.
    loadLibrary("zip");

    FileInputStream fdIn = new FileInputStream(FileDescriptor.in);
    FileOutputStream fdOut = new FileOutputStream(FileDescriptor.out);
    FileOutputStream fdErr = new FileOutputStream(FileDescriptor.err);
    setIn0(new BufferedInputStream(fdIn));
    setOut0(new PrintStream(new BufferedOutputStream(fdOut, 128), true));
    setErr0(new PrintStream(new BufferedOutputStream(fdErr, 128), true));

    // Setup Java signal handlers for HUP, TERM, and INT (where available).
        Terminator.setup();

        // Initialize any miscellenous operating system settings that need to be
        // set for the class libraries. Currently this is no-op everywhere except
        // for Windows where the process-wide error mode is set before the java.io
        // classes are used.
        sun.misc.VM.initializeOSEnvironment();

    // Set the maximum amount of direct memory.  This value is controlled
    // by the vm option -XX:MaxDirectMemorySize=<size>.  This method acts
    // as an initializer only if it is called before sun.misc.VM.booted().
    sun.misc.VM.maxDirectMemory();

    // Set a boolean to determine whether ClassLoader.loadClass accepts
    // array syntax.  This value is controlled by the system property
    // "sun.lang.ClassLoader.allowArraySyntax".  This method acts as
    // an initializer only if it is called before sun.misc.VM.booted().
    sun.misc.VM.allowArraySyntax();

    // Subsystems that are invoked during initialization can invoke
    // sun.misc.VM.isBooted() in order to avoid doing things that should
    // wait until the application class loader has been set up.
    sun.misc.VM.booted();

        // The main thread is not added to its thread group in the same
        // way as other threads; we must do it ourselves here.
        Thread current = Thread.currentThread();
        current.getThreadGroup().add(current);
    }