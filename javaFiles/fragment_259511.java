Pattern pattern =  Pattern.compile("Date Reported.*(\\d{2}/\\d{4} \\d{2}:\\d{2})$", Pattern.MULTILINE);
        String st = "date dfdsfsd fgfd gdfgfdgdf gdfgdfg gdfgdf 3232/22/2010 23:34\n"+
        "dsadsadasDate Reported gdfgfd gdfgfdgdf gdfgdfg gdfgdf 3232/22/2010 23:34";
        Matcher matcher = pattern.matcher(st);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }