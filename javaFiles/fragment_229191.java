BiFunction<BrokerPool, Configuration, DBBroker> constructor =
(BiFunction<BrokerPool, Configuration, DBBroker>)
    LambdaMetafactory.metafactory(
                lookup, "apply", methodType(BiFunction.class),
                mh.type().generic(), mh, mh.type()).getTarget().invokeExact();
//              ^^^^^^^^^^^^^^^^^^^