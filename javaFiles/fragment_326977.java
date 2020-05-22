public ArrayList<Foo> deepCopyFooList(ArrayList<Foo> sourceArray){
   ArrayList<Foo> targetList = new ArrayList<Foo>();
   for (Foo aFoo:sourceArray){
     targetList.add(new Foo(aFoo));
   }

   return targetList;
}