class Administrable {
    public void test(){}
}

public void testAdminIllegal() throws IllegalAccessException, InstantiationException {
    Class clazz = String.class;
    // I thought that this wouldn't even compile
    role.setAdmin(clazz);

    role.getAdministrable().test();
}