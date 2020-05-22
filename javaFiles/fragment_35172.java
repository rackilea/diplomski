JButton Get_Unicode_Button(String unicodeText)
  {
    int emojiCodePoint=Integer.parseInt(unicodeText,16);
    String emojiAsString=new String(Character.toChars(emojiCodePoint));
    JButton button=new JButton(emojiAsString);
    return button;
  }