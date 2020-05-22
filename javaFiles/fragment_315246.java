StringBuilder stringBuilder = new StringBuilder();
    int durationColumnIndex = mCursor.getColumnIndex(PrescriptionContract.PrescriptionEntry.COLUMN_PRESCRIPTION_FREQUENCY_DURATION);
    String duration1 = mCursor.getString(durationColumnIndex);
    String[] duration2 = duration1.split("\\s+");
    for (int x = 0; x < duration2.length; x++) {
        if (duration2[x].length() >= 2) {
            duration2[x] = duration2[x].substring(0, 2);
            stringBuilder.append(duration2[x].substring(0, 2)).append((","));
            Log.v("CatalogActivity", duration2[x] + " rows deleted from prescription database");
        }
    }
    Log.v("CatalogActivity", stringBuilder.toString());