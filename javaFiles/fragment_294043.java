class Child extends Parent {
    private int a = 22;       

    @Override
    public int getA(){
        int superA = super.getA();

        return a+superA;    
    }
 }