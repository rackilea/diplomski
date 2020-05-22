public class DoSomething {
  for (String s : SomeClass.getSomeList()){
    // this create an new string instance to s
    s+="Gotcha"; 
  }
}