public static void main(String[] args) {
           final char RECORD_SEPARATOR = 0x1e;
             final char END_OF_TEXT = 0x03;
             System.out.println(isPrintableChar(RECORD_SEPARATOR));
             System.out.println(isPrintableChar(END_OF_TEXT));
             System.out.println(isPrintableChar('a'));
          }
    public static boolean isPrintableChar( char c ) {
        Character.UnicodeBlock block = Character.UnicodeBlock.of( c );
        return (!Character.isISOControl(c)) &&
                c != KeyEvent.CHAR_UNDEFINED &&
                block != null &&
                block != Character.UnicodeBlock.SPECIALS;
    }