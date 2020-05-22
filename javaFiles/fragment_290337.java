final Class<OUT> newClass = (Class<OUT>) new ByteBuddy()
.subclass(Object.class)
.name(newName)
.implement(SomeInterface.class, SomeOtherInterface.class)
.method(ElementMatchers.isMethod())                            
.intercept(
    ExceptionMethod.throwing(UnsupportedOperationException.class,
                        "calling this method is not supported"))
// in fact I am matching for more than a single method here
.method(ElementMatchers.named("getUuid"))
.intercept(
    MethodDelegation.toInstanceField(SomeOtherInterface.class, "delegate"))
// -- HERE THE FIELD IS MODIFIED AGAIN, IN THIS CASE AS  --
// -- PRIVATE & VOLATILE                                 --
.field(ElementMatchers.named("delegate"))                       
.transform(Transformer.ForField.withModifiers(FieldManifestation.VOLATILE, Visibility.PRIVATE))
.make()
.load(aBusinessEntityClass.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
.getLoaded();