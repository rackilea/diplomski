pointcut isSubTypeOfYourClass(): within(com.your.BaseClass+);
pointcut overridesMethod(): hasmethod(public void yourMethodName(..));
declare parents: isSubTypeOfYourClass() && !overridesMethod()
                 implements com.yourcompany.IllBehaved;
declare error: isSubTypeOfYourClass() && within(com.yourcompany.IllBehaved+):
                 "Implementation class must override <Foo> method";