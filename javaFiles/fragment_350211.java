public class MyHandlerResolver implements HandlerResolver {
    private List<Handler> chain;

    public MyHandlerResolver() {
        chain = new ArrayList<Handler>();
        chain.add(new MyAuthenticationHandler();
    }

    @Override
    public List<Handler> getHandlerChain(PortInfo portInfo) {
        return chain;
    }
}