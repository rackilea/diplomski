import org.springframework.beans.factory.xml.NamespaceHandlerResolver;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomNamespaceHandlerClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {

    private NamespaceHandlerResolver customNamespaceHandlerResolver;

    @Override
    protected void initBeanDefinitionReader(XmlBeanDefinitionReader reader) {
        super.initBeanDefinitionReader(reader);
        reader.setNamespaceHandlerResolver(customNamespaceHandlerResolver);
    }

    public void setCustomNamespaceHandlerResolver(
            NamespaceHandlerResolver customNamespaceHandlerResolver) {
        this.customNamespaceHandlerResolver = customNamespaceHandlerResolver;
    }
}