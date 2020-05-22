String input = "Just to clarify, I will have strings of varying "
      + "lengths. I want to strip characters from it, the exact "
      + "ones to be determined at runtime, and return the "
      + "resulting string.";
    String regx = ",.";
    char[] ca = regx.toCharArray();
    for (char c : ca) {
        input = input.replace(""+c, "");
    }
    System.out.println(input);