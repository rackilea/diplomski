frame.pack();
frame.setVisible(true);

ViewerPipe fromViewer = viewer.newViewerPipe();
fromViewer.addViewerListener(this);
fromViewer.addSink(graph);