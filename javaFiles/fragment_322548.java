Set<String> filesMarshalled= new HashSet<>();
...
final File configurationFile = getConfigurationFile();
if (filesMarshalled.add(configurationFile.getCanonicalPath())) {
    //not marshalled yet
    FileOutputStream fileOutputStream = new FileOutputStream(configurationFile);
    Marshaller.marshal(configObject, fileOutputStream);
}