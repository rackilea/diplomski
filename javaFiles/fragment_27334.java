StreamTokenizer st = new StreamTokenizer(new StringReader("20120101") {
        private int position = 0;
        @Override public int read () throws IOException {
            switch (++ position) {
            case 5:
            case 8:
                return ' ';
            default:
                return super.read();
            }
        }
        @Override public int read (char[] cbuf, int off, int len) throws IOException {
            for (int n = off; n < off + len; ++ n)
                cbuf[n] = (char)read();
            return len;
        }
        @Override public boolean markSupported () {
            return false;
        }
        @Override public void reset () throws IOException {
            position = 0;
            super.reset();
        }
    });

    st.resetSyntax();
    st.wordChars('0', '9');
    st.whitespaceChars(' ', ' ');
    st.nextToken();
    String y = st.sval;
    st.nextToken();
    String m = st.sval;
    st.nextToken();
    String d = st.sval;