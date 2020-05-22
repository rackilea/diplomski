@SneakyThrows
public static JAXBContext getContext()
{
    JAXBContext context;
    context = org.eclipse.persistence.jaxb.JAXBContext.newInstance(Parent.class, Child.class);
    return context;
}