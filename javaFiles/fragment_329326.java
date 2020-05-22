class Child extends Parent {
    public void aMethod(int number){
        //Some other stuff
    }

    @Override
    public void aMethod() {
        throw new UnsupportedOperationException();
    }
}