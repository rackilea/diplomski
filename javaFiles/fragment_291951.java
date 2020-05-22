public class RealmDbGenerator {
    private static final String TAG = RealmDbGenerator.class.getSimpleName();

    public void setGenerationStrategy(GenerationStrategy generationStrategy) {
        this.generationStrategy = generationStrategy;
    }

    private GenerationStrategy generationStrategy;
    private Realm realm;
    private Context context;

    public RealmDbGenerator(Context context) {
        this.realm = Realm.getDefaultInstance();
        this.context = context;
    }

    public void addData(String csvFile, char separator) {
        CSVReader reader;

        int lineNumber = 1;

        try {
                reader = new CSVReader(new InputStreamReader(context.getAssets().open(csvFile)), separator);
                String[] line;

                realm.beginTransaction();
                while ((line = reader.readNext()) != null) {
                    generationStrategy.addData(line, realm);
                }
                realm.commitTransaction();

                reader.close();
        } catch (FileNotFoundException ex) {
            Log.e(TAG, String.format("File %s not found : %s", csvFile, ex));
        } catch (IOException ex) {
            Log.e(TAG, String.format("Error parsing line number %s : %s", lineNumber, ex));
        }
    }
}