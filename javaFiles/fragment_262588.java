interface A { 

   public void foo();

}

interface B extends A { 

   public void bar();

}


class C implements B { 

    @Override
    public void foo() { 

       // implement this
    }

    @Override
    public void bar() { 

       // implement this
    }

}