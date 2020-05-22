public void executeFunction(Class class1) throws Exception{
        for(Method m : class1.getMethods()){
            if(m.getName().equals("sayHi"))
            m.invoke(class1.getConstructor().newInstance());
            //default constructor used to get a object of the class
            //if there is not default constructor this will fail
        }
    }