List<Map<String, Variant<?>>> argumentsToSend = new ArrayList<>();
    argumentsToSend.add( new HashMap<String, Variant<?>>() );
    argumentsToSend.add( new HashMap<String, Variant<?>>() );
    argumentsToSend.get(0).put("arg1", new Variant<Integer>(111));
    argumentsToSend.get(1).put("arg2", new Variant<Integer>(222));

    proxy.getObject().useTheseArgs(argumentsToSend);