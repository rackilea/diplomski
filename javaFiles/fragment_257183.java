@PostContextCreate
public void postContextCreate(IEventBroker eventBroker)
{
  eventBroker.subscribe(UIEvents.UILifeCycle.APP_STARTUP_COMPLETE, new AppStartupCompleteEventHandler());
}


private static final class AppStartupCompleteEventHandler implements EventHandler
{ 
  @Override
  public void handleEvent(final Event event)
  {
    ... your code here
  }
}