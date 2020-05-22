private final Provider<UserImporter> userImporterProvider;

runScoped(() -> {
    UserImporter importer = userImporterProvider.get();
    importer.run();
});