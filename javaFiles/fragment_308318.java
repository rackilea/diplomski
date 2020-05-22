void around(): execution(* MainClass.main(*)) {
    try {
        proceed();
    } catch (Exception e) {
        //suppress
        System.out.println("Suppressed an exception: " 
            + e + "Joinpoint: " + thisJoinPoint.getSignature().toString());
    }
}