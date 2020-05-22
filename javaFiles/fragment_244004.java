@Bean
public LibraryClass getLibraryClass(@Value(${"OAUTH_SERVICE_URL"}) String serviceUrl) {
    LibraryClass libraryClass = new LibraryClass();
    libraryClass.setServiceUrl(serviceUrl);
    return libraryClass;
}