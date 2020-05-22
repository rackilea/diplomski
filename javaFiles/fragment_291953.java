public class PictureStrategy implements GenerationStrategy  {
    private static final String TAG = FlagDefStrategy.class.getSimpleName();

    @Override
    public void addData(String[] line, Realm realm) {
        Picture picture = new Picture(Long.parseLong(line[0]), line[1]);
        Log.d(TAG, String.format("%s %s", line[0], line[1]));
        realm.copyToRealm(picture);
    }
}