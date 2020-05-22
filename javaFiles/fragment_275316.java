@Aspect
@Component
public class ModelAspect {
    @AfterReturning(
        value = "execution(mypackages.Model+ mypackages.api.*.*(..))",
        returning = "model")
    public void doSomethingWithModel(Model model) {
        ...
    }
}