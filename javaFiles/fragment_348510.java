String str =  EntityUtils.toString(response.getEntity());


    int number= str.length(); 
    System.out.println("str-length"+number); //You will see not the length of 3 (for    yes)

    String s2= str.substring(0, 3);  //short the string
    System.out.println("String s2"+s2);

   if(s2.equals("yes"))Log.d("Titles", str);