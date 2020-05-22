String tempString="one|two|three|four|five";
 String str1[]=tempString.split("\\|");
       for(int i=0;i<str1.length;i++)
       {
           Log.i("Str1["+i+"]",str1[i]);
       }