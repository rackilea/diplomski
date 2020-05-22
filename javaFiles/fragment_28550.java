class B extends A<FirstSomething> {
    @Override
    public void setSomething(FirstSomething something) {
        //Set the something
    }
}

class C extends A<SecondSomething> {
    @Override
    public void setSomething(SecondSomething something) {
        //Set the something
    }
}