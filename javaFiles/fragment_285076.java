public void updateDatabase(Context context, SQLiteDatabase database) {

    try (InputStream inputStream = context.getResources().openRawResource(R.raw.teamlist);
        BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));) {

        String line;
        database.beginTransaction();
        while ((line = buffer.readLine()) != null) {
            // read each line from CSV file into a database

        }
        database.setTransactionSuccessful();
        database.endTransaction();
    } catch (IOException ioe){
        Log.e("ERROR", "Could not load " + ioe);
    } catch (UnsupportedEncodingException ioe) {
        Log.e("ERROR", "Could not load " + ioe);
    }
}