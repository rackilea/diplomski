Iterator itr = c.iterator(); 
 T min = (T)itr.next();
 T value;
 while (itr.hasNext()) { 
      value=(T)itr.next();
      if (comp.compare(min, value) < 0) { 
         min = value;  
      }
 }