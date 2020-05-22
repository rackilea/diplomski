@Override  
 public boolean onContextItemSelected(MenuItem item)
 {
      if(item.getTitle() == "Edit") // "Edit" chosen
      {
         // Do stuff
      }
      else if(item.getTitle() == "Delete")  // "Delete" chosen
      {
          // Do stuff
      }
      else 
      {
         return false;
      }

      return true;  
 }