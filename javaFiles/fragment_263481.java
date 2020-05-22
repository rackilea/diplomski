final Reader rd = new StringReader("8a");
    final StreamTokenizer tk = new StreamTokenizer(rd) {
        @Override
        public void parseNumbers() {
            // super.parseNumbers(); - by not calling super. I disable special handling of numeric characters
        }
    };

    tk.wordChars('a', 'z');
    tk.wordChars('0', '9');
    while ((tk.nextToken()) != StreamTokenizer.TT_EOF) {
        if (tk.ttype == StreamTokenizer.TT_WORD) {
            System.out.println("TT_WORD " + tk.sval);
        }
        if (tk.ttype == StreamTokenizer.TT_NUMBER) {
            System.out.println("TT_NUMBER " + tk.nval);
        }
    }