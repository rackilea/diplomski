private Image getHealthIndicatorImage() {
        Image indicatorImage = new Image();
        Pixmap healthIndicator = new Pixmap(AssetLoader.healthIndicatorV);
        Pixmap healthLevel = new Pixmap(healthIndicator.getWidth(), healthIndicator.getHeight(), Format.RGBA8888);

        healthLevel.setColor(Config.InstrumentPanel.healthInstrumentColor1);
        healthLevel.fillRectangle(0, 0, 50, 50);
        healthLevel.drawPixmap(healthIndicator, 0, 0);

        indicatorImage.setDrawable(new TextureRegionDrawable(new TextureRegion(new Texture(healthLevel))));
        indicatorImage.setScaling(Scaling.fit);

        return indicatorImage;
    }