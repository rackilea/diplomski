public boolean imageUpdate(Image img, int infoflags,
               int x, int y, int w, int h) {
    // Don't use getDisabledIcon, will trigger creation of icon if icon
    // not set.
if (!isShowing() ||
        !SwingUtilities.doesIconReferenceImage(getIcon(), img) &&
        !SwingUtilities.doesIconReferenceImage(disabledIcon, img)) {

    return false;
}
return super.imageUpdate(img, infoflags, x, y, w, h);
}