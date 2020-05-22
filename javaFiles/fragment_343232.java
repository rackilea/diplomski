private final LocalServiceTestHelper helper =
          new LocalServiceTestHelper(new LocalUserServiceTestConfig())
              .setEnvIsLoggedIn(true)
              .setEnvAuthDomain("localhost")
              .setEnvEmail("test@localhost");

  @Before
  public void setupCustomerServlet() {
    helper.setUp();
    LocalDatastoreService dsService = (LocalDatastoreService)helper.getLocalService(LocalDatastoreService.PACKAGE);
    dsService.setNoStorage(false);
    customerServlet = new CustomerServlet();
  }

  @After
  public void tearDownHelper() {
    helper.tearDown();
  }

  @Test
  public void testDoGet() throws IOException, ServletException {
    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpServletResponse response = mock(HttpServletResponse.class);

    // A test entry
    Customer customerIn = new Customer();
    customerIn.setName("Felix");
    customerIn.setAddress("Kuestahler");
    String json = (new Gson()).toJson(customerIn);

    StringWriter stringWriter = new StringWriter();

    when(request.getReader()).thenReturn(new BufferedReader(new StringReader(json)));
    when(response.getWriter()).thenReturn(new PrintWriter(stringWriter));

    customerServlet.doPost(request, response);

    Customer customerOut =  (new Gson()).fromJson(stringWriter.toString(), Customer.class);

    assertEquals(customerOut.getName(), customerIn.getName());
    assertEquals(customerOut.get_id() > 0,true);

    stringWriter = new StringWriter();

    when(request.getReader()).thenReturn(new BufferedReader(new StringReader("")));
    when(response.getWriter()).thenReturn(new PrintWriter(stringWriter));

    customerServlet.doGet(request, response);

    System.out.println("Out: "+stringWriter.toString());

  }