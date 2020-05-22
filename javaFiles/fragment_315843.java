@Converter
public class MyBooleanConverter implements AttributeConverter<Boolean, Integer>{
    @Override
    public String convertToDatabaseColumn(Boolean value) {
        if (Boolean.TRUE.equals(value)) {
            return Integer.valueOf(1);
        } else {
            return Integer.valueOf(0);
        }
    }

    @Override
    public Boolean convertToEntityAttribute(Integer value) {
        if(value != null and value.equals(1){
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
}