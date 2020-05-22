String bigWord = "I AM LOUD But also sensitive";

      Pattern pattern = Pattern.compile("([A-Z ]+)? ([A-Z]?.*)");
      Matcher matcher = pattern.matcher(bigWord);
      while(matcher.find()){
         System.out.println(matcher.group(1));
         System.out.println(matcher.group(2));
      }