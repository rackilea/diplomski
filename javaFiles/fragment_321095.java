public class MySpringJUnit4ClassRunner extends SpringJUnit4ClassRunner{
    @Override
    public void run(RunNotifier notifier) {
    EachTestNotifier testNotifier= new EachTestNotifier(notifier,
            getDescription());
    try {
        Statement statement= classBlock(notifier);
        statement.evaluate();
    } catch (AssumptionViolatedException e) {
        testNotifier.fireTestIgnored();
        Logger.error(e);
    } catch (StoppedByUserException e) {
        Logger.error(e);
        throw e;
    } catch (Throwable e) {
        testNotifier.addFailure(e);
        Logger.error(e);
    }
  }
 //...
}