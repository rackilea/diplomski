public aspect Trace {

    String prefix = "";

    Object around(): call(* *(..)) 
        && !within(java..*) 
        && !within(FigureEditor..*) 
        && !cflow(adviceexecution()) {

        System.out.println(prefix+thisJoinPoint.getSignature());
        prefix = ">" + prefix;
        Object result = proceed();
        prefix = prefix.substring(1);

        return result;
    }
}