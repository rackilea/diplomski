public static void ReadFromFile(Scanner input, 
       ArrayList<String> names, 
       ArrayList<Integer> numbers, 
       ArrayList<Character> letters, 
       ArrayList<Double> num2)
{

  while(input.hasNext())
   {
     String val=input.next();
     Object no=parseInt(val);
     if(no!=null) //Is integer?
      {
          numbers.add((Integer)no);
       }
     else
     {
       no=parseDouble(val);
       if(no!=null)  // Is double?
        {
          num2.add((Double)no);
          }
        else
         {
           no=parseChar(val);
           if(no!=null)  //Is Char?
            {
             letters.add((Character)no);
            }
           else
            {
              names.add(val);  // String
            }
         }
       }
    }  
 }