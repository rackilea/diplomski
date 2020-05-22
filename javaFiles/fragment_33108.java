public enum ValidationType {
      TAX_CODE(null); // FIXME

      private final DataValidator<?> validator;

      private ValidationType(DataValidator<?> validator) {
          this.validator = validator;
      }

      public <T> DataValidator<T> getValidator() {
          return (DataValidator<T>)validator;
      }
  }

  public static <T> void validate(T data, ValidationType dataType) {
      dataType.getValidator().validate(data);
  }

  private static abstract class DataValidator<T> {
      public abstract Class<T> getType();
      public abstract void validate(T data);
  }