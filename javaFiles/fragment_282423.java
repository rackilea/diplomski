@Autowired private BillingService billingService;

  public void doSomething(@RequestParam String someParam) {

     billingService.doSomething(someParam);

  }