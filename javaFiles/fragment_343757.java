public class MainActivity extends Activity {

    private ProgressDialog mProgressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        findViewById(R.id.btn_download).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String url = ((EditText) findViewById(R.id.edit_url)).getText().toString().trim();
                Bundle extras = new Bundler().add(DownloadTask.PARAM_URL, url).build();
                Groundy.create(DownloadExample.this, DownloadTask.class)
                        .receiver(mReceiver)
                        .params(extras)
                        .queue();

                mProgressDialog = new ProgressDialog(MainActivity.this);
                mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                mProgressDialog.setCancelable(false);
                mProgressDialog.show();
            }
        });
    }

    private ResultReceiver mReceiver = new ResultReceiver(new Handler()) {
        @Override
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            super.onReceiveResult(resultCode, resultData);
            switch (resultCode) {
                case Groundy.STATUS_PROGRESS:
                    mProgressDialog.setProgress(resultData.getInt(Groundy.KEY_PROGRESS));
                    break;
                case Groundy.STATUS_FINISHED:
                    Toast.makeText(DownloadExample.this, R.string.file_downloaded, Toast.LENGTH_LONG);
                    mProgressDialog.dismiss();
                    break;
                case Groundy.STATUS_ERROR:
                    Toast.makeText(DownloadExample.this, resultData.getString(Groundy.KEY_ERROR), Toast.LENGTH_LONG).show();
                    mProgressDialog.dismiss();
                    break;
            }
        }
    };
}