SimpleAttributeSet error = new SimpleAttributeSet();
StyleConstants.setForeground(error, Color.RED);
StyleConstants.setBackground(error, Color.YELLOW);
StyleConstants.setBold(error, true);

...

doc.insertString(0, "...", error);