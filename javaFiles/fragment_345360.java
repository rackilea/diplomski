private static class EnumSingleValueConverter<T extends Enum<T>> 
   extends AbstractSingleValueConverter { 

    private Class<T> enumType; 

    public static <V extends Enum<V>> SingleValueConverter 
    create(Class<V> enumClass) { 
        return new EnumSingleValueConverter<V>(enumClass); 
    } 

    private EnumSingleValueConverter(Class<T> newEnumType) { 
        this.enumType = newEnumType; 
    } 

    public boolean canConvert(Class type) { 
        return type == enumType; 
    } 

    public Object fromString(String str) { 
        return Enum.valueOf(enumType, str); 
    } 

    public String toString(Object obj) { 
        return obj.toString(); 
    } 
}