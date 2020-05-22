List handlerChain = ((BindingProvider) port).getBinding().getHandlerChain();
if (handlerChain == null) {
    handlerChain = new ArrayList();
}
handlerChain.add(new SOAPAuthenticationHandler(username, password));
((BindingProvider) port).getBinding().setHandlerChain(handlerChain);