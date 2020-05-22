public static void main(String[] args) {
    String    input = "[quote]\n"
        + "Hi to all\n"  
        + "[quote]\n"
        + "im fine\n"
        + "[/quote]\n"
        + "[/quote]\n";

    System.out.println( input.replaceAll( "(?s)\\[quote\\](.*?)\\[/quote]", "<div class=\"quote\">\n[quote]$1[/quote]\n</div>" ));
    System.out.println();
    System.out.println( input.replaceAll( "(?s)\\[quote\\](.*)\\[/quote]", "<div class=\"quote\">\n[quote]$1[/quote]\n</div>" ));
  }