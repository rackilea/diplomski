Subject subject = new Subject();  //Set Principles here
Subject.doAs(subject, new PrivilegedAction<Void>()
{
    public Void run()
    {
        Foo.methodThatCaresAboutSubject();
    }
});