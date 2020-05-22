class Foo {

   @Autowired
   private MyObjList myObjList; 

   //this will invode the interceptor
   public void willWork() {
     myObjList.getMyObjs();
   }

   public void willNotWork() {
     myObjList.getMyObjList(); //will not invoke interceptor since `getMyObjs` is being invoked from inside the class that it's defined
   }

}