String s="Roma Termini 15:00 Milano Centrale 17:55 02:55 FRECCIAROSSA 9638 Price starting from 86.00 ? Select";
       Pattern regex = Pattern.compile("[A-Z]\\w+\\s([A-Z]\\w+|[\\(].*[\\)])+|([0-9:]+(?:(\\.[\\s]|\\.)[0-9]*)?)");
       Matcher matcher = regex.matcher(s);
    while (matcher.find()) {
      System.out.println(matcher.group());
    }