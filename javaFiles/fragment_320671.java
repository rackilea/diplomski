public static void main( String[] args ) {
    String withVowels = "בַּיִת";
    String withoutVowels = "בית";

    String withVowelsTwo = "הַבַּיְתָה";
    String withoutVowelsTwo = "הביתה";

    System.out.println( "These two strings are " + (withVowels.equals( withoutVowels ) ? "" : "not ") + "equal" );
    System.out.println( "The second two strings are " + (withVowelsTwo.equals( withoutVowelsTwo ) ? "" : "not ") + "equal" );

    Collator collator = Collator.getInstance( new Locale( "he" ) );
    collator.setStrength( Collator.PRIMARY );

    System.out.println( collator.equals( withVowels, withoutVowels ) );
    System.out.println( collator.equals( withVowelsTwo, withoutVowelsTwo ) );
}