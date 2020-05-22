pointcut testUpdateFlow() :
    cflow(
        this(Runnable) &&
        cflow(execution(public void Test..*.run(..))) &&
        call(* UpdateRequester.*(..))
    );