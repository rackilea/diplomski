public class classA{
    classA{
        //some code
        classB objectB = new classB(this);  //------------- pass reference here
    }
    public static void main(String[] args){
        classA objectA = new classA();
        //more code
    }
    public void methodA(){
        //even more code
    }
}

public class classB{
    private classA storedReference = null; //------------- you need a variable of classA to store the reference

    public classB(classA passedObject){   //------------- you need an appropriare constructor
        storedReference = passedObject;   //------------- store the classA object reference
    }

    public void someListener(){
        storedReference.methodA();       //------------- call methods whenever necessary
        //code needed to call methodA of the object objectA
    }
}