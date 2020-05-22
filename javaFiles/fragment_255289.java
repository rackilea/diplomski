@Component
public static class PolicyChecker {
    ...
    @Autowired
    private ApplicationContext appContext;
    ...
    public boolean canPersonAccessService(User person, ....) {
       for(String policyName: listPolicy) { 
          Policy policy = appContext.getBean(policyName, Policy.class);
        ....
        policy.canAccess(person);
        ....
      }
    }
}