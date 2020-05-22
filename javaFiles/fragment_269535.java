public aspect MyAspect {

    public MyAspect() {
      System.out.println("Aspect instance created");
    }

   pointcut myPointcut(ParameterType parameter)
               : ("execution(* *(..)) && @annotation(Te));

    Object around(ParameterType parameter) : myPointcut(parameter) {
       // Business logic here
       // 'thisJoinPointStaticPart' will give you access to join point
       // 'this' will give you access to advice instance itself
       // `return proceed();` will allow you to execute advised join point
    }
}