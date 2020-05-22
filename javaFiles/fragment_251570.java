public SessionFactory open (){

    Configuration configuration=new Configuration();
    configuration.configure();
    SessionFactory sf = new Configuration().configure().buildSessionFactory();

    return sf;

}