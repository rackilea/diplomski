public class FlagDefStrategy implements GenerationStrategy {
    private static final String TAG = FlagDefStrategy.class.getSimpleName();

    @Override
    public void addData(String[] line, Realm realm) {
        FlagDef flagDef = new FlagDef(Long.parseLong(line[0]), line[1], line[2]);
        Log.d(TAG, String.format("%s %s %s", line[0], line[1], line[2]));
        realm.copyToRealm(flagDef);
    }
}