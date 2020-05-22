String className = ...;
Class<?> klass = Class.forName(className);
Class<? extends ResponseProvider> responseProviderClass
    = klass.asSubclass(ResponseProvider.class);
ResponseProvider responseProvider = responseProviderClass.newInstance();
return responseProvider.theResponse();