@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {


  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    for (Field field : bean.getClass().getDeclaredFields()) {
      SHL cfgDef = field.getAnnotation(ConfigItem.class);
      if (cfgDef != null) {
        Object instance = getlInstance(field.getType(), cfgDef.key());
        boolean accessible = field.isAccessible();
        field.setAccessible(true);
        try {
          field.set(bean, instance);
        } catch (IllegalArgumentException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } catch (IllegalAccessException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
        field.setAccessible(accessible);
      }
    }
    return bean;
  }