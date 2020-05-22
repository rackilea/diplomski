String regex = "((?<Reserved>\\bPRINTLN\\b|\\bPRINT\\b|\\bINTEGER\\b|\\bINPUT\\b|\\bEND\\b|\\bLET\\b))|((?<Constants>[0-9]+))|((?<Special>[\\[\\]/.$*\\-+=><#()%,!|&{|}]))|((?<Literals>\"[^\"]*\"))|((?<Identifiers>\\w+))";
    String s = "40 println \"Hello \",(5+6-4) ";
    Matcher matcher = Pattern.compile(regex).matcher(s);
    while(matcher.find()) {
        System.out.println(matcher.group());
    }