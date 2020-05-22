// Use this to create a copy of the old property, and change name to new name
    BeanPropertyWriter newBeanPropertyWriter = new CustomBeanPropertyWriter(beanPropertyWriter,"newFieldName");

        public class CustomBeanPropertyWriter extends BeanPropertyWriter {
                protected CustomBeanPropertyWriter(BeanPropertyWriter base, String newFieldName) {
                    super(base, new SerializedString(newFieldName));
                }
            }