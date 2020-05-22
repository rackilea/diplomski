vBar1.addListener(SWT.Selection, new Listener() {
        @Override public void handleEvent(Event arg0) {
        double y = vBar1.getSelection()*xViewerRight.getTree().view.bounds().height/100;
        NSPoint nsPoint = new NSPoint();
        nsPoint.x = 0;
        nsPoint.y = y;
        xViewerRight.getTree().view.scrollPoint(nsPoint);
        }
    });