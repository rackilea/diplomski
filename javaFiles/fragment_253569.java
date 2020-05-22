// Given that all classes in this set are actually subclasses of ClassBase
Set<Class<? extends ClassBase>> classes = Set.of(ClassA.class, ClassB.class, ClassC.class);
System.out.println(classes); // [class test.ClassB, class test.ClassA, class test.ClassC]

@SuppressWarnings("unchecked")
Set<Class<? extends ClassBase<Long>>> result = classes.stream()
    .filter(cls -> {
        // Get superclass, which is ClassBase, so assume it's also parameterized
        ParameterizedType superClass = (ParameterizedType) cls.getGenericSuperclass();
        Type inferred = superClass.getActualTypeArguments()[0]; // get first type argument
        return inferred == Long.class; // check if it's 'Long'
    })
    // Can now say they all extend ClassBase<Long>
    .map(cls -> (Class<? extends ClassBase<Long>>) cls)
    .collect(Collectors.toSet());

System.out.println(result); // [class test.ClassA, class test.ClassB]