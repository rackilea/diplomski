ObjectContainer db = Db4oEmbedded.openFile(Util.DB4OFILENAME);
db.query(new Predicate<MyClass>(){
      public boolean match(MyClass c){
            return c.getName().equals("Joe"); 
      }
})