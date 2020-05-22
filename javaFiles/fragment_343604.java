public void method() {
    Object o=null;
    try {
        o = new Object();
    } catch (Exception e) {
        handleError();
    }
   doSomething(o); 
}