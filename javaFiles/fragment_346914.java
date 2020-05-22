public class SpinnerActivity extends Activity {

    public static final int DIALOG_DOWNLOAD_PROGRESS = 0;
    private ProgressDialog mProgressDialog;

    Spinner spDownloadFrom;
    private ArrayAdapter<CharSequence> spinnerArrayAdapter;
    String url[] = {
            "http://www.becker.cl/bases.pdf",
            "http://www.pitt.edu/documents/campusmap0607.pdf",
            "http://www.aara.ca/reg3317/web_page_doc.pdf",
            "http://www.dataprotection.ie/documents/guidance/GuidanceFinance.pdf",
            "http://www.fmbb2012.com/JumpingQualifica1.pdf",
            "http://www.consulatdumaroc.ca/coloniefh22012.pdf",
            "http://www.rgrdlaw.com/media/cases/140_Complaint.pdf" };
    String name[] = { "bases.pdf", "campusmap0607.pdf", "web_page_doc.pdf",
            "GuidanceFinance.pdf", "JumpingQualifica1.pdf",
            "coloniefh22012.pdf", "140_Complaint.pdf", };
    private boolean checkFlag = false;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mProgressDialog = new ProgressDialog(SpinnerActivity.this);
        mProgressDialog.setMessage("Please be patient, file downloading...");
        mProgressDialog.setIndeterminate(false);
        mProgressDialog.setMax(100);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        spDownloadFrom = (Spinner) findViewById(R.id.Spinner01);

        spinnerArrayAdapter = new ArrayAdapter<CharSequence>(this,
                android.R.layout.simple_spinner_item, name);
        spinnerArrayAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spDownloadFrom.setAdapter(spinnerArrayAdapter);

        SpinnerListener spListener = new SpinnerListener();
        spDownloadFrom.setOnItemSelectedListener(spListener);
    }

    public class SpinnerListener implements OnItemSelectedListener {
        public SpinnerListener() {
        }

        @Override
        public void onItemSelected(AdapterView<?> arg0, View arg1,
                int position, long arg3) {
            if(checkFlag){
                startDownload(position);
            }
            checkFlag = true;

        }
        @Override
        public void onNothingSelected(AdapterView<?> arg0) {

        }
    }

    private void startDownload(int position) {
        DownloadFile downloadFile = new DownloadFile(position);
        downloadFile.execute(url[position]);
    }

    class DownloadFile extends AsyncTask<String, Integer, String> { // put your
                                                                    // download
                                                                    // code
        private int position;

        public DownloadFile(int position) {
            this.position = position;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog.show();
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {
            super.onProgressUpdate(progress);
            mProgressDialog.setProgress(progress[0]);
        }

        @Override
        protected String doInBackground(String... aurl) {
            try {

                URL url = new URL(aurl[0]);
                URLConnection connection = url.openConnection();

                connection.connect();
                int fileLength = connection.getContentLength();
                int tickSize = 2 * fileLength / 100;
                int nextProgress = tickSize;

                Log.d(

                "ANDRO_ASYNC", "Lenght of file: " + fileLength);

                InputStream input = new BufferedInputStream(url.openStream());

                String path = Environment.getExternalStorageDirectory()
                        + "/Android/Data/"
                        + getApplicationContext().getPackageName() + "/files/";
                File file = new File(path);
                file.mkdirs();
                File outputFile = new File(file, name[position]);

                OutputStream output = new FileOutputStream(outputFile);

                byte data[] = new byte[1024 * 1024];
                long total = 0;
                int count;
                while ((count = input.read(data)) != -1) {
                    total += count;
                    if (total >= nextProgress) {
                        nextProgress = (int) ((total / tickSize + 1) * tickSize);
                        this.publishProgress((int) (total * 100 / fileLength));
                    }
                    output.write(data, 0, count);
                }

                output.flush();
                output.close();
                input.close();
                mProgressDialog.dismiss();

            } catch (Exception e) {
                Log.e("Spinner", "exception", e);
            }
            return null;
        }

        protected void onProgressUpdate(String... progress) {
            Log.d("Downloading", progress[0]);

        }

        @Override
        protected void onPostExecute(String unused) {

            mProgressDialog.dismiss();

            File file = new File(Environment.getExternalStorageDirectory()
                    + "/Android/Data/"
                    + getApplicationContext().getPackageName() + "/files/"
                    + name[position]);
            Intent testIntent = new Intent(Intent.ACTION_VIEW);
            testIntent.setType("application/pdf");
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            Uri uri = Uri.fromFile(file);
            intent.setDataAndType(uri, "application/pdf");
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(SpinnerActivity.this,
                        "No Application Available to View PDF",
                        Toast.LENGTH_LONG).show();
            }
        }
    }
}