static void saveDetails(byte[] detailsData) {    
    try (OutputStream os = sContext.openFileOutput(DETAILS_FILE_NAME, Context.MODE_PRIVATE);) {
        os = sContext.openFileOutput(DETAILS_FILE_NAME, Context.MODE_PRIVATE);
        os.write(detailsData);
    } catch (IOException e) {
        Log.w(LOG_TAG, "Unable to save details", e);
    }
}