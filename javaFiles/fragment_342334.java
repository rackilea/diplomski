@Before
public void before(Scenario scenario) {
    System.out.println("------------------------------");
    System.out.println("Starting - " + scenario.getName());
    System.out.println("------------------------------");
}

@After
public void before(Scenario scenario) {
    System.out.println("------------------------------");
    System.out.println(scenario.getName() + " Status - " + scenario.getStatus());
    System.out.println("------------------------------");
}