for(String fileName : fileNames1)
{
 if(!fileNames2.contains(fileName))
   {
     System.out.println(fileName + " is not in both");
   } 
 else
   {
     System.out.println(fileName + " is in both the lists");
   }
}