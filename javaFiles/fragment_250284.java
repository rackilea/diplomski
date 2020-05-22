@Aspect
@Order( value=0 )
public class MyFirstPointcut
{
    @Before("execution(public * com.java.*.data(..))")
    public void something(...) { ... }
}

@Aspect
@Order( value=1 )
public class MySecondPointcut
{
    @Before("execution(public * com.java.science.*.data(..))") 
    public void somethingElse(...) { ... }
}

...etc