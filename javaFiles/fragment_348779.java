public VolatileImage createBackBuffer(WComponentPeer peer) {
    Component target = (Component)peer.getTarget();
    // it is possible for the component to have size 0x0, adjust it to
    // be at least 1x1 to avoid IAE
    int w = Math.max(1, target.getWidth());
    int h = Math.max(1, target.getHeight());
    return new SunVolatileImage(target, w, h, Boolean.TRUE);
}