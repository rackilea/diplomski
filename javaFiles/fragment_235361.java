MyViewer map = new MyViewer();
...
private class MyViewer extends JMapViewer {

    @Override
    public void tileLoadingFinished(Tile tile, boolean success) {
        super.tileLoadingFinished(tile, success);
        lineLayer.repaint(); 
    }
}