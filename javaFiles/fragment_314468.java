AnotherClass anotherVariable = new AnotherClass() {
    private MyClass myVariable;

    public void setMyVariable(MyClass myVariable) {
        this.myVariable = myVariable;
    }

    @Override
    public void method() {
        this.myVariable.invoke();
    }
};

MyClass myVariable = new MyClass(anotherVariable);
anotherVariable.setMyVariable(myVariable);
anotherVariable.method();