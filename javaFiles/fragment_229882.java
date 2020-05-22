while((data=bis.read()) != -1){
   inString += (char)data;

   if (((char)data) == '\n') {
       System.out.println("SLAVE : " + inString);   
       inString = "";
   }
}