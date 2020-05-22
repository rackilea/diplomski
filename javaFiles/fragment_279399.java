import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfig implements InitializingBean {

  @Autowired
  private NullAsEmptyStringSerializer nullSerializer;

  @Autowired
  private ObjectMapper objectMapper;

  // will be called by Spring after all the beans are created
  // and the proper `objectMapper` instance is available here.
  @Override
  public void afterPropertiesSet() throws Exception {
    DefaultSerializerProvider serializerProvider = new DefaultSerializerProvider.Impl();
    serializerProvider.setNullValueSerializer(nullSerializer);
    objectMapper.setSerializerProvider(serializerProvider);
  }

}