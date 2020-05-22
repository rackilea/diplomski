return new ValueTranslator<Enum<?>, String>(path, String.class) {
    @Override
    public Enum<?> loadValue(String value, LoadContext ctx) {
        try{
           return Enum.valueOf((Class<Enum>)type, value.toString());
        }catch(Exception e){
           if (EnumWithDefault.class.isAssignableFrom(enumType)) {
                EnumWithDefault<E> any = (EnumWithDefault<E>) enumType.getEnumConstants()[0];
                result = any.getDefault();
           }else{
              throw e;
           } 
        }
    }