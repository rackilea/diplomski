public ResourceBundle getBeanResourceBundle() {
  Locale fromConfig = DEFAULT_LOCALE;

  //Resolve Locale from a configuration service

  return new MessageSourceResourceBundle(ms, fromNodeConfig); //replace code in my question
}