import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class MyComponent {
}