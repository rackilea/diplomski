JTextPane textPane = new JTextPane();
textPane.setText( "one\ntwo\nthree\nfour\nfive\nsix\nseven\neight" );
StyledDocument doc = textPane.getStyledDocument();

//  Define a keyword attribute

SimpleAttributeSet keyWord = new SimpleAttributeSet();
StyleConstants.setForeground(keyWord, Color.RED);
StyleConstants.setBackground(keyWord, Color.YELLOW);
StyleConstants.setUnderline(keyWord, Boolean.TRUE );
StyleConstants.setBold(keyWord, true);

//  Change attributes on some text

doc.setCharacterAttributes(20, 4, keyWord, false);

//  Add some text

try
{
    doc.insertString(0, "Start of text\n", keyWord );
}
catch(Exception e) {}