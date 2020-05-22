getContentPane().removeAll();
getContentPane().add(controlPanel, BorderLayout.CENTER);
getContentPane().add(backPanel, BorderLayout.SOUTH);
getContentPane().doLayout();
getContentPane().revalidate();
update(getGraphics());