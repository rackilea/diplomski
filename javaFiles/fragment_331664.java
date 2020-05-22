Rectangle drawCrop = getCropBounds();
if (drawCrop != null) {

    Area area = new Area(new Rectangle(0, 0, getWidth() - 1, getHeight() - 1));
    area.subtract(new Area(drawCrop));

    Color color = UIManager.getColor("List.selectionBackground");
    g2d.setColor(color);
    Composite composite = g2d.getComposite();
    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
    g2d.fill(area);
    g2d.setComposite(composite);
    g2d.draw(area);
}