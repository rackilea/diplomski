MyClass myClass = new MyClass();
SomeOtherProcessor01 mockProcessor01 = mock(SomeOtherProcessor01.class);

// reflection bit: find the field by its name
// handle NoSuchFieldException
Field someProcessorField = MyClass.getDeclaredField("someOtherProcessor01");
// the field is declared as private, so make it accessible in order to work with it
someProcessorField.setAccessible(true);
// now set your mocked processor into the field. 
// First argument is the object to change; second argument - new value for the field
someProcessorField.set(myClass, mockProcessor01);