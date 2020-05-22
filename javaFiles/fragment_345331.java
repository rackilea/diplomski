public interface ValuesSystem {

  public interface AllowedValue<T extends SystemValue>{};

  AllowedValue<? extends SystemValue> getAllowedValue(Enum<?> id);

  public <T extends SystemValue> T create
                     (AllowedValue<T> allowedClass, ValueData data);
}