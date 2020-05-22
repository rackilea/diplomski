/**
 * AsyncTask: Profile Image
 * @author Martin Zeitler
**/
public class ProfileImageTask extends AsyncTask<String, Void, Uri> {

    private static final String LOG_TAG = ProfileImageTask.class.getSimpleName();

    private static final boolean mDebug = BuildConfig.DEBUG;

    private String fileName = "photo.jpg";

    private boolean enforce = false;

    private String sdPath;

    private String url;

    /** {@link IProfileImageTask} listener */
    private IProfileImageTask listener;

    /** Constructor */
    @RequiresPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    public ProfileImageTask(@NonNull Context context, @NonNull String url, @NonNull IProfileImageTask listener) {
        this.sdPath = context.getExternalFilesDir(context.getResources().getString(R.string.app_name)) + "/";
        this.listener = listener;
        this.url = url;
    }

    @Override
    protected void onPreExecute() {

        /* setup destination directory */
        File directory = new File(this.sdPath + Constants.FILESYSTEM_DIRECTORY_IMAGES);
        if (! directory.exists()) {
            //noinspection ResultOfMethodCallIgnored
            directory.mkdirs();
        }

        /* setup file name */
        String[] parts = this.url.split("/");
        this.fileName = parts[parts.length - 1];
    }

    @Override
    protected Uri doInBackground(String... arguments) {

        File file = new File(this.sdPath + Constants.FILESYSTEM_DIRECTORY_IMAGES, this.fileName);
        if(file.exists() && this.enforce) {
            if(mDebug) {
                Log.d(LOG_TAG, "delete profile image: " + file.getPath() + ", size: " + file.length() + " bytes.");
            }
            //noinspection ResultOfMethodCallIgnored
            file.delete();
        }

        if (! file.exists()) {
            try {
                URLConnection conn = new URL(this.url).openConnection();
                conn.connect();
                InputStream in = conn.getInputStream();
                FileOutputStream out = new FileOutputStream(file);
                byte[] b = new byte[1024]; int c;
                while ((c = in.read(b)) != -1) {out.write(b, 0, c);}
                out.close();
                in.close();
            } catch (IOException e) {
                if(mDebug) {Log.e(LOG_TAG, "" + e.getMessage());}
            } finally {
                if(mDebug) {
                    Log.d(LOG_TAG, "new cached profile image: "  + file.getPath() + ", size: " + file.length() + " bytes.");
                }
            }
        } else if(mDebug) {
            Log.d(LOG_TAG, "existing profile image: " + file.getPath() + ", size: " + file.length() + " bytes.");
        }
        return Uri.fromFile(file);
    }

    @Override
    protected void onPostExecute(Uri uri) {
        if (listener != null && uri != null) {
            this.listener.OnImageAvailable(uri);
        }
    }
}