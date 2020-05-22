public void register() {
    try
    {
        String language = factory.getLanguageName();

        // Hack to register languages correctly
        if ("ECMAScript".equals(language)) language = "js";
        if ("Groovy".equals(language)) language = "groovy";

        Hashtable<String, Object> properties =
                new Hashtable<String, Object>();

        properties.put("language", language);

        reg = bundle.getBundleContext().registerService(
                LanguageResolver.class,
                new ScriptLanguageResolver(), properties);

        LOG.debug("Register LanguageResolver: " + language);
    } catch(Exception e)
    {
        LOG.warn("Cannot register LanguageResolver: " + e.getClass().getName(), e);
    }
}