public aspect Trace {

    String prefix = "";

    Object around(): call(* *(..)) 
        && !within(java..*)
        && !if(thisJoinPoint.getTarget()!=null && thisJoinPoint.getTarget().getClass().getName().startsWith("java"))
        && !within(FigureEditor..*) 
        && !within(Trace) {

        System.out.println(prefix+thisJoinPoint.getSignature());
        prefix = ">" + prefix;
        Object result = proceed();
        prefix = prefix.substring(1);

        return result;
    }
}