class B extends A
{ 
    protected String b = 'A should get this';

    @Override
    public String getB() { 
        return this.b; 
    } 
}