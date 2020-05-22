public void saveCsv(JSONArray outerArray) throws IOException, JSONException {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        }

        String fileName = referenceNo + " Result";
        String rootPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/test/";
        File dir = new File(rootPath);
        if (!dir.exists()) {
            dir.mkdir();
        }
        File file = null;
        file = new File(rootPath, fileName);
        if (!file.exists()) {
            progressDialog.dismiss();
            file.createNewFile();
        }
        if (file.exists()) {
            progressDialog.dismiss();
            CSVWriter writer = new CSVWriter(new FileWriter(file), ',');
            for (int i = 0; i < outerArray.length(); i++) {
                JSONArray innerJsonArray = (JSONArray) outerArray.getJSONArray(i);


                    arrayOfArrays[k] = stringArray1;
                    writer.writeNext(arrayOfArrays[k]);
                    System.out.println("aa " + Arrays.toString(arrayOfArrays[k]));

                }
            }

            writer.close();
            Toast.makeText(this, fileName + " is been saved at " + rootPath, Toast.LENGTH_LONG).show();
        }
    }
}