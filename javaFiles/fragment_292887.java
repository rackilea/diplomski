import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.core.io.Resource;
import org.springframework.util.Assert;

import java.io.BufferedInputStream;
import java.io.ObjectInputStream;

public class DeserializingFactoryBean extends AbstractFactoryBean
{
    private Resource    source;

    private Class<?>    objectType;

    private int         deserializationCount;

    public DeserializingFactoryBean()
    {
    }

    public DeserializingFactoryBean(Resource source, Class<?> objectType)
    {
        this.source = source;
        this.objectType = objectType;
    }

    public void afterPropertiesSet() throws Exception
    {
        Assert.notNull(objectType, "Property 'objectType' may not be null");
        Assert.notNull(source, "Property 'source' may not be null");
        super.afterPropertiesSet();
    }

    public Resource getSource()
    {
        return source;
    }

    public void setSource(Resource source)
    {
        this.source = source;
    }

    public void setObjectType(Class<?> objectType)
    {
        this.objectType = objectType;
    }

    public Class getObjectType()
    {
        return objectType;
    }

    @Override
    protected Object createInstance() throws Exception
    {
        ObjectInputStream oin = new ObjectInputStream(new BufferedInputStream(source.getInputStream()));
        Object result = oin.readObject();
        if (!objectType.isInstance(result))
            throw new ClassCastException(String.format("Deserialized object is not an instance of %s",objectType.getName()));
        oin.close();
        return result;
    }
}