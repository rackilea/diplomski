String str="{{row1,col1},{row2,col2},{row3,col3}}";

   Pattern pattern = Pattern.compile("(\\w+,\\w+)+");
   Matcher matcher = pattern.matcher(str);

   while (matcher.find()) 
    {
        String search=matcher.group();
        String []ar=search.split(",");
        System.out.println(ar[0] + " " + ar[1]);
    }