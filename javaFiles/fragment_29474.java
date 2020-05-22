class MyApp
{
    MyAnnotation getInstanceOfAnnotation(final String foo)
    {
        MyAnnotation annotation = new MyAnnotation()
        {
            @Override
            public String foo()
            {
                return foo;
            }

            @Override
            public Class<? extends Annotation> annotationType()
            {
                return MyAnnotation.class;
            }
        };

        return annotation;
    }
}