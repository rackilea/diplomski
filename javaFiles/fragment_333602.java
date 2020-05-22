MyCloseable c = MyCloseable.open(...);
try{
       // do stuff with c;
} finally {
     try {
         c.close();
     } catch (IOException e) {
         // ...
     }
}