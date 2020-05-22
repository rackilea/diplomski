String s[] = {"AA", "ABA", "AABBABA"};
   Pattern regex = Pattern.compile("(.)\\1+|.");
   for(String i:s)
   {
       ArrayList<String> fields = new ArrayList<String>();
        Matcher m = regex.matcher(i);
        while(m.find()){

           fields.add(m.group(0));


    }
        System.out.println(fields);
}