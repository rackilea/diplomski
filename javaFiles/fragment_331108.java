@Test
public test1(){
  Project.id = 0;
  Project project1 = new Project();
  Project project2 = new Project();
}
@Test
public test2(){
  // reset the count
  Project.id = 0;
  // here the objects from previous tests are still exist since the   static    field is two times increased
}