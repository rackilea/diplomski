public class SomeActivity extends AppCompatActivity
        implements LoadingResultInterface {

    @Override
    public void onLoadingResult(int errorCode) {
        if (errorCode != xxxxx)
            new SomeLoader(this).execute();
    }
}