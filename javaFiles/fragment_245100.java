List<Object> objList = new List<Object>();
List<String> strList = new List<String>();

doSomething(objList); //OK
doSomething(strList); //OK

public void doSomething(List<?> theList) {
 ///Iterate through list
}