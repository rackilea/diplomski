public class MyBeanFactory
{
    private IServiceFactory serviceFactory;
    private IDecisionMaker decisionMaker;

    public IBean createNewInstance(final String condition)
    {
      String conditionResult = decisionMaker.decide(condition);
      return serviceFactory.getNewInstance(conditionResult);
    }

    public void setServiceFactory(final IServiceFactory serviceFactory)
    {
        this.serviceFactory = serviceFactory;
    }
    public void setDecisionMaker(final IDecisionMaker decisionMaker)
    {
        this.decisionMaker = decisionMaker;
    }
}