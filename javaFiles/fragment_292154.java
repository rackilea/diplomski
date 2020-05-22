public class Sample1 {

    public static void main( String[] str ) {
        ArrayList<String> list = new ArrayList<String>();
        list.add( "General Details|S|!|!|66T4051|N|MACH|a" );
        list.add( "Charge Details|S|!|!|66T4051| 3827|N|" );
        list.add( "Charge Details|S|!|!|66T4051| 3828|N|" );
        list.add( "Insurance Details|S|!|!|66T4051|   f|" );
        list.add( "Insurance Details|S|!|!|66T4051|   h|" );
        list.add( "Insurance Details|S|!|!|66T4051|   p|" );

        StringBuffer mainBuf = new StringBuffer();
        StringBuffer tempBuf = new StringBuffer();

        int count = 0;
        String header = null;
        for( String item : list ) {
            String[] values = item.split( "\\|" );

            // if this is first element
            if( header == null ) {
                header = values[0];
                count = 1;
            }
            // check if the previous element and present element is not same.
            else if(!header.equals(values[0])) {
                append( count, header, mainBuf, tempBuf.toString() );
                tempBuf.delete( 0, tempBuf.length() );
                count = 1;
                header = values[0];
            } else {
                count++;
            }
            if( tempBuf.length() > 0 && tempBuf.charAt( tempBuf.length() - 1 ) != '|' ) {
                tempBuf.append( "|" );
            }
            tempBuf.append( item );
        }
        append( count, header, mainBuf, tempBuf.toString() );

        // replace last character as $ 
        int lastIndex = mainBuf.length();
        mainBuf.replace( lastIndex - 1, lastIndex, "$" );
        System.out.println(" mainBuf => " + mainBuf );
    }

    public static void append( int count, String header, StringBuffer mainBuf, String str ) {
        if( header.equalsIgnoreCase(  "General Details" ) ) {
            mainBuf.append( "ROW" + count + "|" ).append( str );
        } else {
            if( mainBuf.charAt( mainBuf.length() - 1 ) != '|' ) {
                mainBuf.append( "|" );
            }
            mainBuf.append( count + "|" ).append( str );
        }
    }
}