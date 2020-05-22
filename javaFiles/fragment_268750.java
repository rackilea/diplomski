in.close();

         try
         {
             reader.close();//No more error
         }
             catch ( IOException e )
         {
                 System.out.println( e );   
         }
         return fileName;