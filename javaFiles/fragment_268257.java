String s = "AABBABA";
   ArrayList<String> fields = new ArrayList<String>();


        Pattern regex = Pattern.compile("(.)\\1+|.");
        Matcher m = regex.matcher(s);
        while(m.find()){

           fields.add(m.group(0));

    }
    System.out.println(fields);
}