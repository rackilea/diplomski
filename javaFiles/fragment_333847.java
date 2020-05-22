JTextPane myTextPane = new JTextPane();
myTextPane.setContentType("text/html"); 
StringBuilder stringBuilder = new StringBuilder();
stringBuilder.append("<html>");
stringBuilder.append("<b>bold text </b>");
stringBuilder.append("normal text");
stringBuilder.append("</html>");


myTextPane.setText(stringBuilder.toString());