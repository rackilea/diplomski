public class Main extends AsyncTask {
    MyContent myContent = new MyContent(new Handler()) {
        @Override
        public void onChange(boolean selfChange, Uri uri) {
            //posibility to use the uri parameter
            Log.d("d", "onChange fired");
        }
    };
}