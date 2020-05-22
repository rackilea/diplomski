@Override
public VolatileImage createBackBufferImage(Component target,
                                           long backBuffer) {
    return new SunVolatileImage(target,
                                target.getWidth(), target.getHeight(),
                                Boolean.TRUE);
}