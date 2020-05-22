JFrame frame = new JFrame ("Frame");
JTextArea textArea = new JTextArea ("Textarea");

JScrollPane scroll = new JScrollPane (textArea, 
   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

frame.add(scroll);//add Scrollbar to frame