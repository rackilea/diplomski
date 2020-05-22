//Placeholder image

int size = Display.getInstance().convertToPixels(20);
Image placeholder = Image.createImage(size, size, 0xbfc9d2);
Graphics g = placeholder.getGraphics();
g.setAntiAliased(true);
g.setColor(0xbfc9d2);
g.fillArc(0, 0, size, size, 0, 360);

MultiButton[] cmps = new MultiButton[reports.size()];
for (int iter = 0; iter < reports.size(); iter++) {
    Report currentReport = reports.get(iter);
    if (currentReport == null) {
        InfiniteScrollAdapter.addMoreComponents(this.getContentPane(), new Component[0], false);
        return;
    }

    String photoFilenameInStorage = Report.getFilename(currentReport.getPhotoPath());

    String summary = currentReport.getLocation();
    cmps[iter] = new MultiButton(summary);
    // Only shows a black filled circle!
    cmps[iter].setIcon(placeholder);

    Display.getInstance().callSerially(() -> {
       cmps[iter].setIcon( URLImage.createToStorage(cmps[iter].getIcon(), photoFilenameInStorage, currentReport.getPhotoPath(), RESIZE_SCALE_WITH_ROUND_CORNER_MASK));
       cmps[iter].getParent().revalidate();
    });
}
InfiniteScrollAdapter.addMoreComponents(this.getContentPane(), cmps, true);