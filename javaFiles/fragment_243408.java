int[] inputfile () throws Exception{ 
   int[] integerArray = null;
   BufferedReader br = null;
   String sCurrentLine;
   String message;
   br = new BufferedReader(new FileReader("\input.txt"));
   while ((sCurrentLine = br.readLine()) != null) {
       message=sCurrentLine.toString();
       char[] messageArray=message.toCharArray();
       integerArray = new int[messageArray.length];
       for(int i=0; i<messageArray.length; i++)
           integerArray[i] = (int)messageArray[i];
   }
   return integerArray;