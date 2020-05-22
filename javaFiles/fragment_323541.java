private IDataMonitor monitor;

    @Before
    public void setUp() {   
       ...  
       this.monitor = Mockito.mock(IDataMonitor.class); 
       Mockito.when(monitor.getId()).thenReturn("id1");

       this.target = new DataAcquisitionService(..);
       this.target.addMonitor(monitor); // now monitor is in the map
    }

    @Test
    public void test_doSomething() { 
       String id = "id1"; 

       // as our monitor mock with "id1" is in the map, it is found and the register() method is called
       this.target.doSomething(id);

       // verify method call on the mocked monitor
       Mockito.verify(this.monitor, Mockito.times(1)).register(); 
    }