A a1  //the original a
    A a2 = new A();  //the "duplicate"

    Field[] fields = A.class.getDeclaredFields();
    for (Field f : fields){
        f.setAccessible(true); //need that if the fields are not 
        //accesible i.e private fields
        f.get(a1);
        f.set(a2, f.get(a1));
    }