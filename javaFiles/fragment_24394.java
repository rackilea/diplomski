@Test
public void testThatReadDataReturnsACorrectList(){
   MyClass inst = new MyClass(); // Add args to ctor call if needed - maybe a file path that readData() will use?
   inst.myMethod();

   // Create a list of MyClasses that match what you expect readData() to return:
   List<MyClass> expectedList = new List<>();
   expectedList.Add(new MyClass(/* Some arguments */));
   expectedList.Add(new MyClass(/* Some more arguments */));
   expectedList.Add(new MyClass(/* Some other arguments */));

   // Assert that the list you created matches the list you get back from 
   assertArrayEquals("Did not get the list expected", expectedList.ToArray(), inst.getList().ToArray());

}