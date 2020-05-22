DynamicType.Builder<?> builder = ...;
Implementation interceptor = StubMethod.INSTANCE;

// for each field
builder = builder.defineField(bindingName, 
              bindingType, visibility.PRIVATE, FieldManifestation.FINAL);
interceptor = FieldAccessor.ofField(bindingName)
                  .setsArgumentAt( ... )
                  .andThen(interceptor);

interceptor = MethodCall.invoke( ... ).andThen(interceptor);