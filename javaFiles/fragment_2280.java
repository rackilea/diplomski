String s ="x^2+x^2+2x-x-25";
    s=s.replaceAll("(?<!\\d)([a-z])", "1$1");    // <-- replaces any lower letters with 1 concatanted with the same letter
    if(!s.startsWith("-")){
        s="+"+s;  //<-- if the first character is not negative add a + to it.
    }
    System.out.println(s);