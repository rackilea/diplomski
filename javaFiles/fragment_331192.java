public class MyAsyncTask extends AsyncTask<Void, Void, Void>{

    @Override
    protected Void doInBackground(String fileName) {
      url = new URL("http://10.0.2.2:8000/" + filename);
        URLConnection conn = url.openConnection();
        InputStream stream = null;
        try {
            stream = conn.getInputStream();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // more code....

        stream.close();
        return null;
     }
}