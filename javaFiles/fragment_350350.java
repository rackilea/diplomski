@Test
public void testProxy() throws InstantiationException, IllegalAccessException{
    Employee aBean = new Employee();

    //I can modify the bean
    aBean.setName("Obi-Wan");
    aBean.setSurname("Kenobi");

    //create the protected java bean with the generic utility
    Employee protectedBean = Utils.createInmutableBean(Employee.class, aBean);

    //I can read
    System.out.println("Name: "+protectedBean.getName());
    System.out.println("Name: "+protectedBean.getSurname());

    //but I can't modify
    try{
        protectedBean.setName("Luke");
        protectedBean.setSurname("Skywalker");
        throw new RuntimeException("The test should not have reached this line!");
    }catch(Exception e){
        //I should be here
        System.out.println("The exception was expected! The bean should not be modified (exception message: "+e.getMessage()+")");
        assertEquals("Obi-Wan", protectedBean.getName());
        assertEquals("Kenobi", protectedBean.getSurname());
    }
}