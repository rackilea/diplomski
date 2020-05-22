void around(): execution(* MainClass.main(*)) {
    try {
        //before() code
        System.out.println("Before main started.");

        proceed();

        //after() returning code
        System.out.println("Main exited normally.");
    } catch (Exception e) {
        //after() throwing code suppressing exception unless you rethrow it
        System.out.println("Suppressed an exception: " + e + "Joinpoint: " 
            + thisJoinPoint.getSignature().toString());
    } finally {
        //after() code
        System.out.println("After main executed.");
    }
}