// in TestService
private ITestProvider testProvider;

@DynamicReference
public void setTestProvider(ITestProvider testProvider) { ... }

// Getting the method
while(clazz != null) {
    for (Method method : clazz.getDeclaredMethods()) {
        DynamicReference dynamicRefrence = method.getAnnotation(DynamicReference.class);
        if(dynamicRefrence != null)
            methodsWithAnnotation.add(method);
    }
    clazz = clazz.getSuperclass();
}

// invoking it
method.invoke(proxyInstance, dependencyInstanceYouWantToSet);