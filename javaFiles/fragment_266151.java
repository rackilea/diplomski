public class ProgressListener implements OnProgressListener {

    @Override
    public void onProgress(int percentage, Object tag) {
        System.out.println( (String)tag + " " + percentage + "%" );

    }

}