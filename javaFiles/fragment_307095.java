Instrumentation inst = InstrumentHook.getInstrumentation();
for (Class<?> c: inst.getAllLoadedClasses()) {
    if (MyInterface.class.isAssignableFrom(c)) {
         check if c is the rigth implementation!.
    }
}