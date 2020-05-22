private void loadJsonFromStream() throws IOException {

    InputStream stream = getAssets().open("school.json");
    InputStream streamSetting = getAssets().open("setting.json");

    realm.beginTransaction();
    try {
        realm.createAllFromJson(School.class, stream);
        realm.createAllFromJson(Setting.class, streamSetting);
        realm.commitTransaction();
    } catch (IOException e) {
        // Remember to cancel the transaction if anything goes wrong.
        realm.cancelTransaction();
    } finally {
        if (stream != null && streamSetting != null) {
            stream.close();
            streamSetting.close();


        }
    }

}