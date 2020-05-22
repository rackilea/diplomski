import stackoverflow.somepackage.B;
class Main{

        public String getUserInput(){
            return "I 'am user foo";
        }

}

class A{

    public void callB() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class loadedClass = B.class;
        Method executeApp = loadedClass.getMethod("execute", Object.class);
        executeApp.invoke(loadedClass.newInstance(),Main.class.newInstance());
    }

}