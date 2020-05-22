@ServiceProvider(service = ImporterBuilder.class)
public final class TalendCollectionImporterBuilder implements ImporterBuilder {

public String getName() {
       return "Talend Flow Connection Importer";
    }

    public SpigotImporter buildImporter() {
       return new TalendCollectionImporter();
    }

}