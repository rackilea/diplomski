while(!checkupdates){
        FetchUpdatedsneeded();
       if (checkupdates) {
          execute FetchUpdates();        
          break;
       }

}