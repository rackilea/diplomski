List<SuperClass> myList = new ArrayList<>();
myList.add(new ChildClass());
myList.add(new AnotherChildClass());
myList.add(new ChildClass());
//...

// later
(for (SuperClass s : myList) {
   s.doSomeThing();
}