pointcut testUpdateFlow() :
    cflow(
        this(Runnable) &&
        withincode(public void Test..*.run(..)) &&
        call(* UpdateRequester.*(..))
    );