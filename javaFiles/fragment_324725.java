// Use the key, Label.disabledForeground
UIManager.put("Label.disabledForeground",Color.RED);

JLabel l=new JLabel("Label Disabled");
l.setEnabled(false);
// You get a red foreground