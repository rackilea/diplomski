private static final Map<String,Integer> m_map = new HashMap<String,Integer>();
 static {
     m_map.put( "program", 1 );
     m_map.put( "begin", 2 );
     m_map.put( "end", 3 );
     m_map.put( "int", 4 );
     m_map.put( "if", 5 );
 }

 private int evaluateWord(String sval) {
     Integer value = m_map.get( sval );
     if ( null != value ) {
        return value;
     }
     else {
        System.exit(0);
     }
 }