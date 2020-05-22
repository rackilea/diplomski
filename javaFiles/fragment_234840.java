import org.apache.catalina.Context;
import org.apache.catalina.Lifecycle;
import org.apache.catalina.LifecycleEvent;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.deploy.ContextEnvironment;
import org.apache.commons.lang.StringUtils;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class LogbackContextNameListener implements LifecycleListener {

    private static final Log logger = LogFactory
            .getLog(LogbackContextNameListener.class);
    private Context context;

    private String name = "logback/contextName";

    @Override
    public void lifecycleEvent(LifecycleEvent le) {

        if (le.getLifecycle() instanceof Context)
            context = (Context) le.getLifecycle();
        else
            return;

        if (le.getType().equals(Lifecycle.START_EVENT)) {
            ContextEnvironment ce = new ContextEnvironment();
            ce.setName(getName());
            ce.setOverride(false);
            ce.setType("java.lang.String");
            String value = StringUtils.remove(context.getServletContext()
                    .getContextPath(), '/');
            ce.setValue(value);
            logger.debug(String.format("Adding env entry '%s' with value '%s'",
                    getName(), value));
            context.getNamingResources().addEnvironment(ce);
        }

        if (le.getType().equals(Lifecycle.STOP_EVENT)) {
            logger.debug(String.format("Removing env entry '%s'", getName()));
            context.getNamingResources().removeEnvironment(name);
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (StringUtils.isEmpty(name))
            throw new IllegalArgumentException(
                    "Parameter 'name' cannot be empty");

        this.name = name;
    }

}