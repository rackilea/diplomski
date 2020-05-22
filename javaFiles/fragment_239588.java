public class Main extends Activity{

FFmpeg ffmpeg;
Context context;

protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    context = this;

    loadFFmpeg();
    String cmd="ffmpeg -i /storage/emulated/0/media/audio/a.mp3 -i  /storage    /emulated/0/recording.3gp -filter_complex \"[0:a][1:a]amerge=inputs=2[aout]\" -map \"[aout]\" " + outputFile;
    executeFFmpeg(cmd.split(" "));

}

private void loadFFmpeg() {
    ffmpeg = FFmpeg.getInstance(context);
    try {
        ffmpeg.loadBinary(new LoadBinaryResponseHandler() {

            @Override
            public void onStart() {}

            @Override
            public void onFailure() {}

            @Override
            public void onSuccess() {}

            @Override
            public void onFinish() {}
        });
    } catch (FFmpegNotSupportedException e) {
        // Handle if FFmpeg is not supported by device
    }
}

private void executeFFmpeg(String[] cmd)
{
    try {
        ffmpeg.execute(cmd, new ExecuteBinaryResponseHandler() {

            @Override
            public void onStart() {}

            @Override
            public void onProgress(String message) {}

            @Override
            public void onFailure(String message) {}

            @Override
            public void onSuccess(String message) {}

            @Override
            public void onFinish() {
                stop.setEnabled(false);
                play.setEnabled(true);
            }
        });
    } catch (FFmpegCommandAlreadyRunningException e) {
        // Handle if FFmpeg is already running
    }
}
}