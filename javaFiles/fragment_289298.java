public interface MyInterface{
}

class  MySuperMostClass implements MyInterface{

}

class  MyBaseClass extends MySuperMostClass{
    public void methodA(){
    }

    public void methodB(){
    }
}

class MySubClass extends MyBaseClass{

    @override
    public void methodA(){
        methodB();
    }

    @override
    public void methodB(){
    }
}