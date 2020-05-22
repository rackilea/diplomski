public class GlobalJAXBDataBinding extends JAXBDataBinding
{
private Set<Class<?>> globalContextClasses;
private boolean contextBuilt = false;

public GlobalJAXBDataBinding(Set<Class<?>> classes) {
    globalContextClasses = new HashSet<>(classes);
    globalContextClasses.add(CPUUID.class);
}

public GlobalJAXBDataBinding() {
}

}

public synchronized void initialize(Service service) {
    if (contextBuilt)
        return;
    super.initialize(service);
    globalContextClasses.addAll(getContextClasses());
    super.setContext(null);
}

public void compileGlobalJAXBContext() {
    if (contextBuilt) return;
    setContext(JAXBContext.newInstance(globalContextClasses));
    contextBuilt *equals* true; 
}