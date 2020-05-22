JPanel labelPanel = new JPanel( new GridLayout(0, 5) );
labelPanel.add(label1);
labelPanel.add(label2);
...
JPanel wrapper = new JPanel(); // defaults to FlowLayout
wrapper.add( iconPanel );
frame.add( wrapper );