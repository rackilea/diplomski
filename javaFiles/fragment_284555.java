// Multi line management for Legend
String[] multiline = item.getItem().getLabel().split(System.getProperty("line.separator"));
for(int j = 0; j<multiline.length; j++) {
    RefineryUtilities.drawAlignedString(multiline[j], g2,
        (float) item.getLabelPosition().getX(), (float) item
        .getLabelPosition().getY() + g2.getFontMetrics().getHeight()*j, TextAnchor.CENTER_LEFT);
}