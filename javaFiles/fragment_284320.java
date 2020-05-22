Container pane = frame.getContentPane();
pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

for(Robot r: robots) {
    JProgressBar bar = new JProgressBar();
    robotBars.put(r, bar);
    bar.setMinimum(0);
    bar.setMaximum(MAX);
    pane.add(bar);
}

frame.pack();
frame.setVisible(true);