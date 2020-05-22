String valueTwoWords [] = valueTwo.split(" "); // if value = "I went" 
                                               // valueTwoWords = ["I","went"]
for(String getTerm : checkValues)
 {
    for(int i = 0; i < valueTwoWords.length(); i++)
    {
       if(valueTwoWords[i].compareTo(getTerm) == 0) // If the words are the same.
       {
            int foundTermPosition = valueTwo.indexOf(getTerm); 
            lead = valueTwo.substring(0, foundTermPosition-1);
            index = valueTwo.length() - lead.length();

            leftOver = valueTwo.substring(foundTermPosition+getTerm.length(), valueTwo.length());

            out.write(lead);
            out.write("<A HREF=\"#" + getTerm + "\">" + getTerm + "</A>");
            out.write(leftOver + "\n");
            i = valueTwoWords.length() + 1; // getting out of the cycle.
       }
     }
   }