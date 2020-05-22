StyledDocument styleDocument =  jTextPane1.getStyledDocument();
  Style primaryStyle = styleDocument.addStyle("Primary", null);
  Style secondaryStyle = styleDocument.addStyle("Secondary", primaryStyle);


  StyleConstants.setFontFamily(primaryStyle, "American Captain");
                        // use font-family from your platform
  StyleConstants.setFontSize(primaryStyle, 24);

  StyleConstants.setFontFamily(secondaryStyle, "Bira PERSONAL USE ONLY");
                       // use font-family from your platform
  StyleConstants.setFontSize(secondaryStyle, 20);
  StyleConstants.setForeground(primaryStyle, new Color(0x552AFF));
  StyleConstants.setForeground(secondaryStyle, Color.black);

  try {
      styleDocument.insertString(0, "Title with American Captain font\n\n", primaryStyle);
      styleDocument.insertString(styleDocument.getLength(), "Font demonstration with JTextPane. "
              + "Seriously, it is powerful and has the power to do all kind of styling with text. "
              + "check it out, check its mighty power and be embrassed\n", secondaryStyle);
   } catch (BadLocationException ex) {
                Logger.getLogger(JTextPaneTest.class.getName()).log(Level.SEVERE, null, ex);
   }