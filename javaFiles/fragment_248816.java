//window.setLayout(new BoxLayout(window, BoxLayout.Y_AXIS));
JPanel contentPane = new JPanel();
contentPane.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

...

//window.add(display);
//window.add(row1);
//window.add(row2);
//window.add(row3);
//window.add(row4);
contentPane.add(display);
contentPane.add(row1);
contentPane.add(row2);
contentPane.add(row3);
contentPane.add(row4);
window.add(contentPane);