Reflections reflections = new Reflections("my.project.prefix");

 Set<Class<? extends SomeType>> subTypes = 
           reflections.getSubTypesOf(SomeType.class);

 Set<Class<?>> annotated = 
           reflections.getTypesAnnotatedWith(SomeAnnotation.class);

 Set<Class<?>> annotated1 =
           reflections.getTypesAnnotatedWith(new SomeAnnotation() {
                public String value() { return "1"; }
                public Class<? extends Annotation> annotationType() { 
                    return SomeAnnotation.class; 
                }
            });