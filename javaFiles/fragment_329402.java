anObject getObjByID(int id){           
    for(anObject obj : objList ){      
      if (obj.getID() == id){
        return node;        
         }        
    }
  throw new MyException("Element Not Found");           
}