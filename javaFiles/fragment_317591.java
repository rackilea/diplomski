// Insert the cells via the cache, so they get selected
graph.getGraphLayoutCache().insert(cells);

// Show in Frame
JFrame frame = new JFrame();
frame.getContentPane().add(new JScrollPane(graph));
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.pack();
frame.setVisible(true);