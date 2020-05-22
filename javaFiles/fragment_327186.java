String regex = "(?<=\\s{%s})%s(?=\\s{%s})";
String numSpaces = "1";
String number = "0.3";
String replacement = "32.2";
String yourString = "1111 1.0 2222 53.5 3333 0.3 4444 541.1";
yourString = yourString.replaceAll(String.format(regex, numSpaces, number, numSpaces),
                                   replacement);
System.out.println(yourString);
//prints 1111 1.0 2222 53.5 3333 32.2 4444 541.1