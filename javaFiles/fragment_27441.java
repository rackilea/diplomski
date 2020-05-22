package freemarker.adhoc;

import java.util.List;

import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

/**
 * Creates an FTL method that calls the constructor of the given class. Supports overloading and varargs. 
 */
public class ConstructorTemplateModel implements TemplateMethodModelEx {

    private final Class constructorClass;
    private final BeansWrapper objectWrapper;

    /**
     * @param objectWrapper
     *            The same {@link ObjectWrapper} used in the {@link Configuration}, or {@code null} if we should
     *            find the current {@link ObjectWrapper} for each constructor call (slower).
     */
    public ConstructorTemplateModel(Class<?> constructorClass, BeansWrapper objectWrapper) {
        this.constructorClass = constructorClass;
        this.objectWrapper = objectWrapper;
    }

    @Override
    public Object exec(List/*<TemplateModel>*/ arguments) throws TemplateModelException {
        BeansWrapper objectWrapper = this.objectWrapper;
        if (objectWrapper == null) {
            objectWrapper = getCurrentBeansWrapper();
        }

        return objectWrapper.newInstance(constructorClass, arguments);
    }

    private BeansWrapper getCurrentBeansWrapper() {
        Environment env = Environment.getCurrentEnvironment();
        if (env == null) {
            throw new IllegalStateException("No ongoing template processing");
        }

        ObjectWrapper objectWrapper = env.getObjectWrapper();
        if (!(objectWrapper instanceof BeansWrapper)) {
            throw new IllegalStateException("The object wrapper must be a BeansWrapper. Object wrapper class: "
                    + objectWrapper.getClass().getName());
        }

        return (BeansWrapper) objectWrapper;
    }

}