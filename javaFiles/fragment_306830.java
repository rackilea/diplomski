void
runCocoaMain()
{
    void* clazz = objc_getClass("NSApplication");
    void* app = objc_msgSend(clazz, sel_registerName("sharedApplication"));

    objc_msgSend(app, sel_registerName("run"));
}