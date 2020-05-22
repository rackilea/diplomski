public enum DataType { NUMBER, STRING; }
public enum Backend { SQL, IN_MEMORY; }

@BindingAnnotation @Retention(SOURCE) @Target({ FIELD, PARAMETER, METHOD })
public @interface Store {
  DataType dataType();
  Backend backend();
}