for(int i=0;i<sl.length;i++){
   boolean found = false;
   for(int j=0;j<Mids.length;j++){
      if((sl[i].equals(Mids[j]))){
         found = true;
         break;
      }
   }

   if (found) {
      stdOut.println("Action");
   } else {
      stdOut.println("Action cannot be set");
   }
}