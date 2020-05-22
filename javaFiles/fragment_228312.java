Module libraryModule = SomeLibraryClass.class.getModule();
Optional<ModuleDescriptor.Version> libraryVersion =
    libraryModule.getDescriptor().version();

ModuleDescriptor.Version minimumRequiredVersion =
    ModuleDescriptor.Version.parse("2.0");

if (libraryVersion.isPresent() &&
    minimumRequiredVersion.compareTo(libraryVersion.get()) >= 0) {

    System.out.println(libraryModule + " is version " +
        minimumRequiredVersion + " or later.");
}