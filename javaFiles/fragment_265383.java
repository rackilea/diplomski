private EnumInterface[] enumList;//declared globally.

if(flagTrue){
    enumList = Enum1.values();
}else{
    enumList = Enum2.values();
}
....
....
private method1(int position){
    EnumInterface[position].processEvent(this);
}


public void doSomethingA(){
    //Whatever you needed to switch on A for
}

public void doSomethingB(){
    //Whatever you needed to switch on B for
}

....
....