String string = "This is a test string!";
     String letters = "aeiou";
     Pattern pattern = Pattern.compile("[" + letters + "]");
     Matcher matcher = pattern.matcher(string);
     int position = -1;
     if (matcher.find()) {
         position = matcher.start();
     }
     System.out.println(position); // prints 2