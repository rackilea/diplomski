numberOfRetries = 0;
   maxRetries = 4;  

   nextDoc = getFirstDocWithRetries(view);   // this contains while loop and try-catch

   while (nextDoc != null)
   { 
       processOneDoc(nextDoc);
       nextDoc = getNextDocWithRetries(view,nextDoc);   // and so does this
   }