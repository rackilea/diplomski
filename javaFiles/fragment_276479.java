InputStream stream = LocaleManager.class.getClassLoader().getResourceAsStream(path);
ResourceBundle bundle = new PropertyResourceBundle(new InputStreamReader(stream, "UTF-8"));

//get internationalized version for "Swimming"
String str = _("Swimming");

//create and configure JLabel
JLabel label = new JLabel();
label.setVisible(true);
label.setBackground(Color.yellow);
label.setOpaque(true);

//this line was the issue
label.setFont(new Font("Verdana", Font.PLAIN, 14));

//setting text which results in squares
label.setText(str);