Canvas drawWidget = new Canvas(composite, SWT.NONE);
drawWidget.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

drawWidget.addPaintListener(new PaintListener() {
    @Override
    public void paintControl(final PaintEvent e) {
        Rectangle r = drawWidget.getClientArea();
        e.gc.drawOval(0, 0, r.width - 1, r.height - 1);
    }
});