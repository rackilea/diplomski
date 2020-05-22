public void reloadDefaultConfiguration() throws JoranException {
  ContextInitializer ci = new ContextInitializer(loggerContext);
  URL url = ci.findURLOfDefaultConfigurationFile(true);
  loggerContext.reset();
  ci.configureByResource(url);
}