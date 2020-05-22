public static void main(String[] args)
  {
     customSplit("{1,24,5,[8,5,9],7,[0,1]}");
  }


  static void customSplit(String str){
     Pattern pattern = Pattern.compile("[0-9]+|\\[.*?\\]");
     Matcher matcher =
           pattern.matcher(str);
     while (matcher.find()) {
        System.out.println(matcher.group());
     }
  }