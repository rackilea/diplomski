public class AnnotationContextFactory implements FactoryBean<ApplicationContext> {

private String[] packages;
private ApplicationContext parent;

@Override
public ApplicationContext getObject() throws Exception {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.setParent(parent);
    context.scan(packages);
    context.refresh();
    return context;
}

@Override
public Class<ApplicationContext> getObjectType() {
    return ApplicationContext.class;
}

@Override
public boolean isSingleton() {
    return true;
}

public void setPackages(String... args) {
    this.packages = args;
}

public void setParent(ApplicationContext parent) {
    this.parent = parent;
    }
}