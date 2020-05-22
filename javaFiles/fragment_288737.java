public class CustomBeanPropertyWriter extends BeanPropertyWriter {

        protected Field setField(Field newValue){
            super._field = newValue;
        }

        protected CustomBeanPropertyWriter(BeanPropertyWriter base, String newFieldName, Field newFieldValue) {
            super(base, new SerializedString(newFieldName));
            setField(newFieldValue);
        }
    }