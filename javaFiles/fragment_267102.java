final JPanel info = new JPanel(new BorderLayout()); // <-- Change me :D
final JScrollPane infoS = new JScrollPane(info,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
// These are bad ideas, setLocation and setSize won't work, as the panel should be
// under the control of a layout manager
//info.setLocation(10,78);
//info.setSize(420,490);
//infoS.setPreferredSize(new Dimension(600, 600));
gui.add(infoS);