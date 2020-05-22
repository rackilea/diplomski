JFrame frame=new JFrame();
JEditorPane pane=new JEditorPane();
pane.setContentType("text/html");
String data="<table border=\"1\"><tr><td>cell1</td><td>cell2</td></tr></table>";
pane.setText(data);

frame.add(pane);
frame.setSize(200,200);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

frame.setVisible(true);