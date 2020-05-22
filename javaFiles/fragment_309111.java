abstract MySuperClass{
    float x,y;
    MyArrayObj myarrayobj;//this is new'ed.
}
Class1 extends MySuperClass{
    // Class1 specific fields and methods
}
Class2 extends MySuperClass{
    // Class2 specific fields and methods
}

static myGenericMethod(MySuperClass myObj){
    float x = myObj.x;
    float pt = myObj.myarrayobj.array[0];
}