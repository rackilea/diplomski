@Override
public void init(ServletContext servletContext) throws TemplateException {
    super.config = super.createConfiguration(servletContext);
    super.config.setTemplateExceptionHandler(new CustomTemplateExceptionHandler());
    super.contentType = "text/html";
    super.wrapper = super.createObjectWrapper(servletContext);
    if (LOG.isDebugEnabled()) {
        LOG.debug("Using object wrapper of class " + super.wrapper.getClass().getName(), new String[0]);
    }

    super.config.setObjectWrapper(super.wrapper);
    super.templatePath = servletContext.getInitParameter("TemplatePath");
    if (super.templatePath == null) {
        super.templatePath = servletContext.getInitParameter("templatePath");
    }

    super.configureTemplateLoader(super.createTemplateLoader(servletContext, super.templatePath));
    super.loadSettings(servletContext);
}

@Override
protected Configuration createConfiguration(ServletContext servletContext) throws TemplateException {
    Configuration configuration = new Configuration();
    configuration.setTemplateExceptionHandler(new CustomTemplateExceptionHandler());
    if (super.mruMaxStrongSize > 0) {
        configuration.setSetting("cache_storage", "strong:" + super.mruMaxStrongSize);
    }

    if (super.templateUpdateDelay != null) {
        configuration.setSetting("template_update_delay", super.templateUpdateDelay);
    }

    if (super.encoding != null) {
        configuration.setDefaultEncoding(super.encoding);
    }

    configuration.setLocalizedLookup(false);
    configuration.setWhitespaceStripping(true);
    return configuration;
}