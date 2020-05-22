public static void main(String[] args) throws IOException {
    String input = "<img alt=\"\" src=\"http://abchdfgjd.com/justin-bieber-ferns-650-430.jpg\" "
            + "width=\"650\" height=\"430\" /> Have you seen <a href=\"http://www.funnyordie.com/between_two_ferns\" "
            + "target=\"_blank\">Between Two Ferns</a>?";
    int pos = input.indexOf(">");
    String ans1 = input;
    String ans2 = "";
    if (pos > -1) {
        ans1 = input.substring(0, pos + 1);
        ans2 = input.substring(pos + 2);
    }
    System.out.println("ans1: " + ans1);
    System.out.println("ans2: " + ans2);        
}