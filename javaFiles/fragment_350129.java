public class homeOperation extends AsyncTask<String,Void,String> {

    List<String> title_list = new ArrayList<String>();
    List<String> id_list = new ArrayList<String>();

    Context context;
    Handler handler;
    AlertDialog alertDialog;

    homeOperation(Context ctx, Handler hnd) {
        context = ctx;
        handler = hnd;
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String login_url = "http://xxxx/data.php";
        if (type.equals("home")) {
            try {
                String events = params[1];
                String task_owner = params[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("events", "UTF-8") + "=" + URLEncoder.encode(events, "UTF-8") + "&"
                        + URLEncoder.encode("task_owner", "UTF-8") + "=" + URLEncoder.encode(task_owner, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                String[] arr = result.split("--");
                for (int i = 0; i < arr.length; i++) {
                    String cur = arr[i];
                    title_list.add(cur.split(":")[0]);
                    id_list.add(cur.split(":")[1]);
                }

                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected void onPostExecute(String result) {
        Toast toast = Toast.makeText(this.context, result, Toast.LENGTH_LONG);
        toast.show();

        handler.sendEmptyMessage(0);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}