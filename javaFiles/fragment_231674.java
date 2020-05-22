Pattern p = Pattern.compile("DS \\#18 \\[([0-9\\.]*)\\\\([0-9\\.]*)\\] Pixel Spacing",
                            Pattern.MULTILINE|Pattern.DOTALL); 
Matcher m = p.matcher( input );
while( m.find() ) {
    System.out.println("[ "+m.group( 1 )+", "+m.group( 2 )+" ]");
}