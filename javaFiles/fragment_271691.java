String s1 = "#hello|#what|whatsup|";
     String s2 = "#hello#";
     String s3 = "|ola|1";
     String s4 = "|hello#|what#whatsup#node";

     Pattern pattern = Pattern.compile("((\\w)+)(\\||#)(\\||#)?");
     Matcher matcher = pattern.matcher(s4);
     while(matcher.find()) {
         System.out.println(matcher.group(1) + (matcher.group(4) != null ? matcher.group(4).equals("|")? "#" : "|" : ""));
         matcher.find(); //to jump over the next match
     }