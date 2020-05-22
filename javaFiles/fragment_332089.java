Class A{

    public boolean method(int x){
        //do something to x
        return true;
    }

};

Class MainClass{

    public static void Main(){
        A someObject = new A();                     // create an object of class A
        boolean result = someObject.method(5);      // call the method of that object 
    }
};