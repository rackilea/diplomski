private final URLImage.ImageAdapter RESIZE_SCALE_WITH_ROUND_MASK = new URLImage.ImageAdapter() {
    @Override
    public EncodedImage adaptImage(EncodedImage downloadedImage, EncodedImage placeholderImage) {
        Image tmp = downloadedImage.scaledLargerRatio(placeholderImage.getWidth(), placeholderImage.getHeight());
        if (tmp.getWidth() > placeholderImage.getWidth()) {
            int diff = tmp.getWidth() - placeholderImage.getWidth();
            int x = diff / 2;
            tmp = tmp.subImage(x, 0, placeholderImage.getWidth(), placeholderImage.getHeight(), true);
        } else if (tmp.getHeight() > placeholderImage.getHeight()) {
            int diff = tmp.getHeight() - placeholderImage.getHeight();
            int y = diff / 2;
            tmp = tmp.subImage(0, y, Math.min(placeholderImage.getWidth(), tmp.getWidth()),
                    Math.min(placeholderImage.getHeight(), tmp.getHeight()), true);
        }
        Image roundMask = Image.createImage(tmp.getWidth(), tmp.getHeight(), 0xff000000);
        Graphics gr = roundMask.getGraphics();
        gr.setColor(0xffffff);

        gr.fillArc(0, 0, tmp.getWidth(), tmp.getHeight(), 0, 360);
        Object mask = roundMask.createMask();
        tmp = tmp.applyMask(mask);
        return EncodedImage.createFromImage(tmp, false);
    }

    @Override
    public boolean isAsyncAdapter() {
        return true;
    }
};