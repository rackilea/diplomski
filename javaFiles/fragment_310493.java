axis.resizeRelocate(0, getHeight() /4, getWidth(), axisHeight);
// doesn't make a difference, shouldn't be needed anyway
//axis.requestAxisLayout();
// working hack from bug report:
axis.layout();
double pixelOnAxis = axis.getDisplayPosition(value.getValue());
thumb.relocate(pixelOnAxis, getHeight() /4);