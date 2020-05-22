for(int i=0; i<m.size(); i++){
   if (m.get(i) == null) {
     if (n.get(i) != null) {
       result = true;
     }
   } else if(!(m.get(i).equals(n.get(i)))){   
     result = true;
   } 
   if (result) {
     break;
   }
}