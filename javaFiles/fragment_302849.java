protected void setCrosshairLocation(double x, Double y) {
    Crosshair domainCrosshair;
    List domainCrosshairs = crosshairOverlay.getDomainCrosshairs();
    if (domainCrosshairs.isEmpty()) {
        domainCrosshair = new Crosshair();
        domainCrosshair.setPaint(BlueStripeColors.LIGHT_GRAY_C0);
        crosshairOverlay.addDomainCrosshair(domainCrosshair);
    }
    else {
        // We only have one at a time
        domainCrosshair = (Crosshair) domainCrosshairs.get(0);
    }
    domainCrosshair.setValue(x);

    if (y != null) {
        Crosshair rangeCrosshair;
        List rangeCrosshairs = crosshairOverlay.getRangeCrosshairs();
        if (rangeCrosshairs.isEmpty()) {
            rangeCrosshair = new Crosshair();
            rangeCrosshair.setPaint(BlueStripeColors.LIGHT_GRAY_C0);
            crosshairOverlay.addRangeCrosshair(rangeCrosshair);
        }
        else {
            // We only have one at a time
            rangeCrosshair = (Crosshair) rangeCrosshairs.get(0);
        }

        rangeCrosshair.setValue(y);
    }
}