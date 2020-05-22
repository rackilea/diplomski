public class BeanProcessor {
   public static void main(String[] args) {
      try {
         final Class<?> beanClazz = BBean.class;
         BeanInfo info = Introspector.getBeanInfo(beanClazz);
         PropertyDescriptor[] propertyInfo = info.getPropertyDescriptors();
         for (final PropertyDescriptor descriptor : propertyInfo) {
            try {
               final Field field = beanClazz.getDeclaredField(descriptor
                     .getName());
               System.out.println(field);
               for (final Annotation annotation : field
                     .getDeclaredAnnotations()) {
                  System.out.println("Annotation: " + annotation);
               }

            } catch (final NoSuchFieldException nsfe) {
               // ignore these
            }
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}