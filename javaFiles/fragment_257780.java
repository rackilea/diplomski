private Client client;

@Before
public void setUp() {
    this.client = ClientBuilder.newClient();
}

@After
public void tearDown() {
    this.client.close();
}