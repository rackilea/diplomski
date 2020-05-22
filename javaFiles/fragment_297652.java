import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.cfg.DeserializerFactoryConfig;
import com.fasterxml.jackson.databind.deser.BeanDeserializerFactory;
import com.fasterxml.jackson.databind.deser.ResolvableDeserializer;
import com.fasterxml.jackson.databind.type.SimpleType;
...
    public abstract class RestDtoDeserializer<T> extends JsonDeserializer<T>
    {
        @Override
        public T deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException
        {
            DeserializationConfig config = ctxt.getConfig();
            SimpleType simpleType = SimpleType.construct(getImplementationClass());
            BeanDescription beanDesc = config.introspect(simpleType);
            BeanDeserializerFactory instance = new BeanDeserializerFactory(new DeserializerFactoryConfig());
            JsonDeserializer deserializer = instance.buildBeanDeserializer(ctxt, simpleType, beanDesc);
            ((ResolvableDeserializer)deserializer).resolve(ctxt);
            return (T) deserializer.deserialize(jp, ctxt);
        }

        public abstract Class<? extends T> getImplementationClass();