Class[] classes = Constants.class.getDeclaredClasses();     
    for(Class innerClass: classes){
        //System.out.println(innerClass.getName());
        Field[] fields = innerClass.getDeclaredFields();
        for(Field field : fields){
            //System.out.println(field.getName());
            //your implementation
        }           
    }