@Step
public abstract class TestAopComp {
    public abstract void test();
}

@Component
public class TestAopCompImpl extends TestAopComp{
    public void test(){
        System.out.println("test");
    }
}

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Step {
}

@Component
@Aspect
public class Aspect {
    @Pointcut("@within(Step)")
    public void stepClass(){}

    @Around("stepClass()")
    public void stepAround(ProceedingJoinPoint pjp){
        System.out.println("before");
        try {
            pjp.proceed(pjp.getArgs());
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("after");
    }
}