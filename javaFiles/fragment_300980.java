interface I {
    void f() throws MyException;
}

class A implements I {
    public void f() throws MyException {
         try {
             ...
         } catch (IOException e) {
             throw new MyException(e);
         }
    }
}

class B implements I {
    public void f() throws MyException {
         try {
             ...
         } catch (InterruptedException e) {
             throw new MyException(e);
         }
    }
}