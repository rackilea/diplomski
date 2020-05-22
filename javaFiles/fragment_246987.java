public void update()
{
    try
    {
        lock();
        eglSwapBuffers(eglDisplay, surface);
        unlock();
    }
    catch (Exception e)
    {
        System.out.println("Swap buffers failed");
    }
}