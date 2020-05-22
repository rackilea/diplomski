FooWrapper wrapper = new FooWrapper(delegate);
    Foo delegate = Mockito.mock(Foo.class);

    // For each method in the Foo class...
    for (Method fooMethod : Foo.class.getDeclaredMethods()) {
        boolean methodCalled = false;

        // Find matching method in wrapper class and call it
        for (Method wrapperMethod : FooWrapper.class.getDeclaredMethods()) {
            if (fooMethod.getName().equals(wrapperMethod.getName())) {

                // Get parameters for method
                Class<?>[] parameterTypes = wrapperMethod.getParameterTypes();
                Object[] arguments = new Object[parameterTypes.length];
                for (int j = 0; j < arguments.length; j++) {
                    arguments[j] = Mockito.mock(parameterTypes[j]);
                }

                // Invoke wrapper method
                wrapperMethod.invoke(wrapper, arguments);

                // Ensure method was called on delegate exactly once with the correct arguments
                fooMethod.invoke(Mockito.verify(delegate, Mockito.times(1)), arguments);

                // Set flag to indicate that this foo method is wrapped properly.
                methodCalled = true;
            }
        }

        assertTrue("Foo method '" + fooMethod.getName() + "' has not been wrapped correctly in Foo wrapper", methodCalled);
    }