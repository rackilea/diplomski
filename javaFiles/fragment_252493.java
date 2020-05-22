@Override
    protected File doInBackground(Void... params) {

        Context context = contextWeakReference.get();

        AssetManager assetManager = context.getAssets();

        File file = new File(fileRoot, fileName);

        InputStream in = null;
        OutputStream out = null;
        try {

            file.mkdirs();

            if (file.exists()) {
                file.delete();
            }

            file.createNewFile();


            in = assetManager.open(fileName);
            Log.d(TAG, "In");

            out = new FileOutputStream(file);
            Log.d(TAG, "Out");

            Log.d(TAG, "Copy file");
            copyFile(in, out);

            Log.d(TAG, "Close");
            in.close();

            out.flush();
            out.close();

        } catch (Exception e)
        {
            Log.e(TAG, e.getMessage());
        }
            return file;

     }