GetObject_Service_Impl impl = new GetObject_Service_Impl();
        // Get Iterator for all service ports
        Iterator iter = impl.getPorts();

        // Now create a new List of HandlerInfo objects - only one really.
        // Our client handler
        List handlerChain = new ArrayList();
        handlerChain.add(new HandlerInfo(SoapHandler.class, null, null));

        // Get Handler Registry
        HandlerRegistry registry = impl.getHandlerRegistry();
        // Register each port with the handler
        while (iter.hasNext())
            registry.setHandlerChain((QName) iter.next(), handlerChain);