class MyReader extends FilterReader {
    private String line;
    private int pos;
    public MyReader(BufferedReader in) { 
        super(in);
        line = null;
        pos = 0;
    }
    @Override
    public int read() {
        try {
            if ( line == null || pos >= line.length() ) {
                do {
                    line = ((BufferedReader)in).readLine();
                } while ( line != null && line.length() == 0 );
                if ( line == null ) return -1;
                line = line + "\r\n";
                pos = 0;
            }
            if ( line.contains("-------------------- Section ") ) {
                line = null;
                return -1;
            }
            return line.charAt(pos++);
        } catch ( Exception e) { throw new RuntimeException(e); }
    }
}