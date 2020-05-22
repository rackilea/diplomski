@Aspect
public class MyAspect {

    @Pointcut("execution(* CannotAmend.methodThree(..))")
    public void methodThreePointcut(){
    }

    @After("methodThreePointcut()")
    public void afterMethod(JoinPoint joinPoint) throws NoSuchFieldException, IllegalAccessException {
        Object instance = joinPoint.getThis();

        Field privateUriField = instance.getClass().getDeclaredField("privateUri");
        privateUriField.setAccessible(true);

        String privateUri = (String) privateUriField.get(instance);
        System.out.println(privateUri); // prints "something"
    }
}