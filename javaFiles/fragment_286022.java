String line = "This order was placed for QT3000! OK?";
String pattern = "((.*?)(\\d{2}))(?:(\\d{2})(.*))";
Pattern r = Pattern.compile(pattern);
      Matcher m = r.matcher(line);
      while(m.find( )) {
         System.out.println("Found value: " + m.group(1));
         System.out.println("Found value: " + m.group(4));
         System.out.println("Found value: " + m.group(5));
         System.out.println("Found value: " + m.group(2));
         System.out.println("Found value: " + m.group(3) + m.group(4));
         System.out.println("Found value: " + m.group(5));
     }