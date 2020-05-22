private void myMethod(List<?> list) {
    for(Object o : list) {
        if(o instanceof MyFirstClass) {
            MyfirstClass p = (MyFirstClass)o;
            p.myFirstMethod();
        } else if(o instanceof MySecondClass) {
            MySecondClass p = (MyFirstClass)o;
            p.mySecondMethod();
        }
    }
}