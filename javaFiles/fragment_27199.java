// Here fruits is the Arraylist<String> object that contains your elements 

    for(String str:fruits)
    {
        if(str.contains("FRUITS"))
        {
         continue;
        }
      System.out.println(str);
    }