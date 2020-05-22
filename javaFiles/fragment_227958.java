public class MyFlowExecutionListener extends FlowExecutionListenerAdapter{
    @Override
    public void eventSignaled(RequestContext context, Event event) {...}
    @Override
    public void transitionExecuting(RequestContext context, TransitionDefinition transition) {...}
    @Override
    public void viewRendered(RequestContext context, View view, StateDefinition viewState) {...}
    @Override
    public void exceptionThrown(RequestContext context, FlowExecutionException exception) {...}
    ...
}