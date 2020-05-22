InputStreamReader inputStream = new InputStreamReader(System.in);
 BufferedReader bufferedReader = new BufferedReader(inputStream);
 while(true)
 {
     if (bufferedReader.ready())
     {
         String s = bufferedReader.readLine();
         // do stuff before exiting loop
         break;
     }
     // do stuff in loop 
 }