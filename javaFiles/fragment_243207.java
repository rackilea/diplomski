public class WidgetFilterReader
    extends FilterReader
{
    private StringBuilder sb = new StringBuilder();

    @SuppressWarnings( "unused" )
    private final String search;
    private final String replace;
    private Pattern pattern;
    private static final String EOF = "\uFFEE";  // half-width white circle - Used as to place holder and token

    /**
     * 
     * @param search A regular expression to build the pattern.  Example: "<colors>([^<>]+?)\\s*<\\/colors>"
     * @param replace A String value with up to two parts to prefix and suffix the found group(1) object, separated by a pipe: ie |.  
     *          Example: "<color>*</color>"
     * @param in
     */
    protected WidgetFilterReader( String search, String replace, Reader in ) {
        super( in );
        this.search = search;
        this.replace = replace;
        this.pattern = Pattern.compile(search);
    }

    @Override
    public int read()
            throws IOException {
        int read = ingest();
        return read;
    }

    private int ingest() throws IOException
    {
        if (sb.length() == 0) {
            int c = super.read();
            if ( c < 0 )
                return c;
            sb.append( (char) c );
        }

        if ( sb.length() > 0 && sb.charAt(0) == '<' ) {
            int count = 0;
            for ( int i = 0; i < sb.length(); i++ ) {
                if ( sb.charAt( i ) == '>' )
                    count++;
            }
            int c2;
            while ((c2 = super.read()) >= 0 && count < 2) {
                sb.append( (char) c2 );
                if (c2 == '>')
                    count++;
            }
            if ( c2 < 0 )
                sb.append( EOF );
            else
                sb.append( (char) c2 );

            Matcher m = pattern.matcher( sb.toString() );
            if ( m.find(0) ) {
                String grp = m.group(1);
                int i = sb.indexOf(grp);
                if ( i >= 0 ) {
                    int j = i + grp.length();
                    String[] r = replace.split( "\\|" );
                    sb.replace(i, j, (r.length > 0 ? r[0] : "") + grp + (r.length > 1 ? r[1] : ""));
                }
            }
        }

        int x = sb.charAt(0);
        sb.deleteCharAt(0);

        if ( x == EOF.charAt(0) )
            return -1;
        return x;
    }

    @Override
    public int read( char[] cbuf, int off, int len )
            throws IOException {
        int c;
        int read = 0;

        while (read < len && (c = ingest()) >= 0 ) {
            cbuf[off + read] = (char) c;
            read++;
        }
        if (read == 0)
            read = -1;
        return read;
    }
}