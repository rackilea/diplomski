final String path = "http://localhost:8080/RestEasy-Spring-MVC-Hibernate/";
ICustomerService proxy = null;

    @Before
    public void beforeClass(){
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target(UriBuilder.fromPath(path));
        proxy = target.proxy(ICustomerService.class);
    }

@Test
    public void testCustomerByIdNewAPI() throws Exception{  
        CustomerType customerType = proxy.getCustomerInfo(1);
        System.out.println("----------------------------------------------------");
        System.out.println("Name       : "+customerType.getName());
        System.out.println("Age        : "+customerType.getAge());
        System.out.println("CustomerId : "+customerType.getCustomerId());
    }