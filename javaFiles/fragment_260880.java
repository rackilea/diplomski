class Foo
{    
    private String var;

    Object getVar() {
        return var;
    }
}

class B extends Foo
{
    private int var;

    @Override
    Object getVar() {
        return var;
    }
}