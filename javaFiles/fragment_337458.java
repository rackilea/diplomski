ViewerPipe fromViewer = viewer.newViewerPipe();
fromViewer.addViewerListener(this);
fromViewer.addSink(graph);

frame.pack();
frame.setVisible(true);