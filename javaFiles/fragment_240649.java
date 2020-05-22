for(int i=0;i<a.size();i++)
    for(int j=0;j<b.size();j++)
       if(a.get(i).getId().equals(b.get(j).getId()){
         //this id from A exists in B. Replace
         b.get(j)=a.get(i);
       }
       else{
          if(j=(b.size()+1)){ // if true the whole b list have been searched
             //object not found. Add it to b
             b.add(a.get(i));      
          } 
}