String s = "new Array(new Array('1','Hello'),new Array('2','World (New) Again'),new Array('3','Now'));";
Pattern regex = Pattern.compile("[(,]new\\sArray\\(((?:(?!\\),new\\sArray|\\)+;).)*)\\)");
 Matcher matcher = regex.matcher(s);
 while(matcher.find()){
        System.out.println(matcher.group(1));
 }