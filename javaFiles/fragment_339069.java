@Aspect
public class DaoAspect {
    @AfterThrowing(/*any method in a @Repository class that is not annotated with @ExceptionHandler*/ throwing="ex")
    public void doRecoveryActions(DataAccessException ex) {
        //find method of throwing class that can handle the exception via @ExceptionHandler
    }
}