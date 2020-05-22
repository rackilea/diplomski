String s1 = "#hello|#what|whatsup|";
     String s2 = "#hello#";
     String s3 = "|ola|1";
     String s4 = "|hello#|what#whatsup#node";
     String s5 = "#||##||MiddleRecursion||##||#";

     Pattern pattern = Pattern.compile("(#|\\|)((#|\\|)*\\w+(#|\\|)*)(#|\\|)");
     Matcher matcher = pattern.matcher(s1);
     while(matcher.find()) {
         System.out.println(matcher.group(2));
     }