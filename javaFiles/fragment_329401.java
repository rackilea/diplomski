anObject getObjByID(int id){           
  for(anObject obj : objList ){      
    if (obj.getID() == id){
     return node;       // will return when searching matched 
    }        
  }          
  return null; // will return matching not found.
}