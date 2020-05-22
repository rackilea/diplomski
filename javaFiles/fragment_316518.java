public class MyAutowiredBeanPostProcessor implements BeanPostProcessor {

        @Autowired
        ApplicationContext context;

        @Override
        public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
            Class<?> beanClass = bean.getClass();
            Field[] declaredFields = beanClass.getDeclaredFields();
            for (Field field : declaredFields) {
                MyAutowired annotation = field.getAnnotation(MyAutowired.class);
                if (annotation != null){
                    Class<?> type = field.getType();
                    Object beanForInjection = context.getBean(type);
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, bean, beanForInjection);
                }
            }
            return bean;
        }