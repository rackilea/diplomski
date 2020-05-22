final Binding binding = ((BindingProvider) servicePort).getBinding();
List<Handler> handlerList = binding.getHandlerChain();
if (handlerList == null)
    handlerList = new ArrayList<Handler>();

handlerList.add(new SecurityHandler());
binding.setHandlerChain(handlerList); // <- important!