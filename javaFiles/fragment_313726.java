//If the String object "txt" matches the given regex, which in this case is "Who is the(.*)"
  if (txt.matches("Who is the(.*)")) {
        String re1=".*?";   
        String re2="(?:[a-z][a-z]+)";   
        String re3=".*?";
        String re4="(?:[a-z][a-z]+)";   
        String re5=".*?";   
        String re6="(?:[a-z][a-z]+)";   
        String re7=".*?";   
        String re8="((?:[a-z][a-z]+))"; 
        String re9=".*?";   
        String re10="(?:[a-z][a-z]+)";  
        String re11=".*?";  
        String re12="((?:[a-z][a-z]+))";


        //this creates a pattern using the above strings.
        Pattern p = Pattern.compile(re1+re2+re3+re4+re5+re6+re7+re8+re9+re10+re11+re12,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);

        //creates matcher object from the String object "txt"
        Matcher m = p.matcher(txt);

        //m.find() "Attempts to find the next subsequence of the input sequence that matches the pattern.", if it does...
        if (m.find())
        {
            //m.group "Returns the input subsequence matched by the previous match."
            String word1=m.group(1);
            String word2=m.group(2);
            //creates a string
            String z=word2.toString()+"&&"+word1.toString();
            //prints out string
            System.out.println(z);
    }
    }