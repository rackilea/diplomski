Container progress = new Container(new LayeredLayout());
Label percent = new Label("0%");
percent.getUnselectedStyle().setAlignment(Component.CENTER);
progress.add(new Label(progressOverlayImage, "Container")).
        add(FlowLayout.encloseCenterMiddle(percent));
progress.getUnselectedStyle().setBgPainter((Graphics g, Rectangle rect) -> {
    g.setColor(0xff0000);
    g.fillArc(progress.getX(), progress.getY(), progressOverlayImage.getWidth(), progressOverlayImage.getHeight(), 0, currentProgress360);
});