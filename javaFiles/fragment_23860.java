String text = "Hear no evil";
JLabel label = new JLabel(text);
System.out.println( label.getPreferredSize() );
System.out.println( label.getInsets() );

JCheckBox checkBox = new JCheckBox(text);
System.out.println( checkBox.getPreferredSize() );
System.out.println( checkBox.getInsets() );