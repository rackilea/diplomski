public static void main(String[] args) 
{
myclass test = new myclass();
List<String> objectA = test.ListA(args[0]);
List<String> objectB = test.ListB(args[1]);         
test.DoSomething(objectA, objectB);
}

public List<String> ListA(String aaa){
List<String> generatedA;
//Generate your object...
return generatedA;
}   

public List<String> ListB(String bbb){
List<String> generatedB;
//Generate your object...
return generatedB;
}

public static void DoSomething(List<String>objectA, List<String>objectB}{
//other codes goes here...
}