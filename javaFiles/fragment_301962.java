Pattern MY_PATTERN = Pattern.compile("\\[(.*?)\\]");
        Matcher m = MY_PATTERN.matcher("Hello @[---68---] and @[---64---] and d@[---102---]");
         while (m.find()) {
           String s = m.group(1);
           System.out.println(s.split("---")[1]);
       }