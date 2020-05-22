public class DoThing extends AsyncTask<Object, String, File> {
    @Override
    protected File doInBackground(Object... params) {
        String stringy = (String) params[0];
        File file = (File) params[1];
        // do hard work
        return file;
    }
}