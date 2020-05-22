private static BufferedImage renderImg = device.getDefaultConfiguration().
        createCompatibleImage(
                    device.getDisplayMode().getWidth(),
                    device.getDisplayMode().getHeight());
static {
    renderImg.setAccelerationPriority(1);
}