public static void main (String [] args){
    String given = "dsfhgs the dgfre fh \n" +
            "hjfgeh fhg hghjr \n" +
            "fhvhjf the vgh fhjghf \n" +
            "fbvhjfd  fhvfg fjvhf \n" +
            "the hfdvhjf vhf  fhdvjfd \n" +
            "hfvbhd thehjdvhj hdfvhdf." ;
    String[] lines = given.split("\n");
    String searchStr = "the";       
     for(String line : lines)
     {

         String[] wordOfLine = line.split(" ");
         boolean match = false;
         for(String word : wordOfLine)
         {
                if (searchStr.equals(word)) 
                {
                    match = true;
                } 
         }

         if(match)
         {
             System.out.println("Found value: " + searchStr);
         }
         else 
         {
             System.out.println("NO MATCH");
         }

    }


}