String regex = "(";
    for (int i = 0 ; i < validPair.length ; i++) {
        regex += (i == 0 ? "" : "|") +  // add "or" after first item
                "\\Q" +  // quote entire input string so it is not interpreted as regex
                validPair[i] +  // this is what we are looking for, duhh 
                "\\E";  // end quote
    }
    regex += ")";
    System.out.println("using regex : " + regex);
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(toCheck);

    while (m.find()) {
        System.out.println(m.group(0));
    }