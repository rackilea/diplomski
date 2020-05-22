public static final CharSequenceTranslator ESCAPE_JAVA = 
      new LookupTranslator(
        new String[][] { 
          {"\"", "\\\""},
          {"\\", "\\\\"},
      }).with(
        new LookupTranslator(EntityArrays.JAVA_CTRL_CHARS_ESCAPE())
      ).with(
        JavaUnicodeEscaper.outsideOf(32, 0x7f) 
    );