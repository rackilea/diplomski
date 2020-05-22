numberOfRetries = 0;
   maxRetries = 4;   

   // get first document, with retries

   needToRetry = false;
   while (needToRetry)
   {
      try
      {
         while (needToRetry)
         {
            nextDoc = myView.getFirstDocument();
            needToRetry=false;
         }    
      }
      catch (NotesException e) 
      {
         numberOfRetries++;
         if (numberOfRetries < maxRetries) {
            // you might want to sleep here to wait for the network to recover
            // you could use numberOfRetries as a factor to sleep longer on
            // each failure
            needToRetry = true;
         } else {
            // write "Max retries have been exceeded getting first document" to log
            nextDoc = null; // we won't go into the processing loop 
         }
      }
   }

   // process all documents

   while(nextdoc != null) 
   {

      // process nextDoc
      //   insert your code here


      // now get next document, with retries

      while (needToRetry)
      {
         try
         {
            nextDoc = myView.getNextDocument();
            needToRetry=false;
         }  
         catch (NotesException e) 
         {
            numberOfRetries++;
            if (numberOfRetries < maxRetries) {
               // you might want to sleep here to wait for the network to recover
               // you could use numberOfRetries as a factor to sleep longer on
               // each failure
               needToRetry = true;
            } else {
               // write "Max retries have been exceeded getting first document" to log
               nextDoc = false; // we'lll be exiting the processing loop without finishing all docs 
            }
         }
      }
   }