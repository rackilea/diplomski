Autocloseable ac = null;
Exception e = null;
try {
   ac = new Autocloseable();
   //Do something
} catch (Exception e1) {
   e = e1
   //Do something with exception
} finally {
  if(ac != null) {
     try {
       ac.close();
     } catch (Exception e2) {
        throw e == null? e2 : e;
     }
     if(e != null ) throw e; 
  }
}