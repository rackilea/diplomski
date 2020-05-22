public enum King{
    ELVIS
}

@SuppressWarnings({ "unchecked", "rawtypes" })
public static void main(final String[] args){
    final Class<? extends Enum> enumType = King.class;
    final Enum<?> theOneAndOnly = Enum.valueOf(enumType, "ELVIS");
    System.out.println(theOneAndOnly.name());
}