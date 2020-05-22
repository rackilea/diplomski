import org.springframework.core.*;
import org.springframework.util.ClassUtils;

public class CustomParameterNameDiscoverer extends PrioritizedParameterNameDiscoverer {
    private static final boolean kotlinPresent = ClassUtils.isPresent("kotlin.Unit", CustomParameterNameDiscoverer.class.getClassLoader());

    public CustomParameterNameDiscoverer() {
        if (kotlinPresent) {
            this.addDiscoverer(new KotlinReflectionParameterNameDiscoverer());
        }

        this.addDiscoverer(new ReqParamNamesDiscoverer());
        this.addDiscoverer(new StandardReflectionParameterNameDiscoverer());
        this.addDiscoverer(new LocalVariableTableParameterNameDiscoverer());
    }
}