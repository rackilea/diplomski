public static void main( String[] args ) {
    String expression = "[(sin(1+3*4)+2)/7]+10";
    LinkedList<String> vars = new LinkedList<>();

    Pattern p = Pattern.compile("(?:[^0-9a-zA-Z]|\\G|^)([0-9a-zA-Z]+)(?:[^0-9a-zA-Z]|$)");
    Matcher m = p.matcher( expression );

    while(m.find()) {
        vars.add( m.group( 1 ) );
    }

    for(String s : vars ) {
        // Here's where you'd filter out the functions like "sin", "cos", etc.
        System.out.println( s );
    }
}