public class EnumAlternativeValueHelper {


  private static <ValueType,EnumType extends Enum<EnumType> & EnumAlternativeValue<ValueType>> EnumType safeGetByAlternativeValue(Class<EnumType> enumClass, ValueType value) {
    for ( EnumType enumInstance : EnumSet.allOf(enumClass) ) {
      if ( enumInstance.getAlternativeValue().equals(value) ) {
        return enumInstance;
      }
    }
    return null;
  }


  public static <ValueType,EnumType extends Enum<EnumType> & EnumAlternativeValue<ValueType>> Optional<EnumType> getIfPresent(Class<EnumType> enumClass, ValueType value) {
    EnumType t = safeGetByAlternativeValue(enumClass,value);
    return Optional.fromNullable(t);
  }


  public static <ValueType,EnumType extends Enum<EnumType> & EnumAlternativeValue<ValueType>> EnumType valueOf(Class<EnumType> enumClass, ValueType value) {
    EnumType t = safeGetByAlternativeValue(enumClass,value);
    return checkNotNull(t,"No alternative value of " + enumClass + " correspond to the provided alternative value = [" + value+"]");
  }


  public static <ValueType,EnumType extends Enum<EnumType> & EnumAlternativeValue<ValueType>> Optional<EnumType> valueOfNullSafe(Class<EnumType> enumClass, ValueType value) {
    if ( value == null) {
      return Optional.absent();
    }
    return Optional.of( valueOf(enumClass,value) );
  }

  public static <ValueType> Function<EnumAlternativeValue<ValueType>,ValueType> getAlternativeValueFunction() {
    return new Function<EnumAlternativeValue<ValueType>,ValueType>() {
      @Override
      public ValueType apply(EnumAlternativeValue<ValueType> input) {
        return input.getAlternativeValue();
      }
    };
  }

}