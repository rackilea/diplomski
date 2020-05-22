List<Object> objList = new List<Object>();
List<String> strList = new List<String>();

DoSomething(objList); //OK
DoSomething(strList); //OK

public void DoSomething<T>(IEnumerable<T> theList) {
 ///Iterate through list
}