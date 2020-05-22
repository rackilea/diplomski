class myClass<T> implements myClassInterface<T extends myInterface>{
       String myMethod(){
            T myType;
            return myType.abc();
       }
}