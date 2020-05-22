public class CallRecorder extends Service {
    private static final int RECORDER_SAMPLERATE = 8000;
    private static final int RECORDER_CHANNELS = AudioFormat.CHANNEL_IN_MONO;
    private static final int RECORDER_AUDIO_ENCODING = AudioFormat.ENCODING_PCM_16BIT;
    private MediaRecorder recorder;
    private NotificationManager notificationManager;

    public CallRecorder() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        try {
            recorder = new MediaRecorder();
            int audioSource;

            try {
                recorder.setAudioSource(audioSource);

            } catch (RuntimeException e) {
                recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
            }


            recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
            recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
            recorder.setAudioSamplingRate(RECORDER_SAMPLERATE);
            Log.e("path recording", intent.getStringExtra("recording_name"));

            File folder = new File(Environment.getExternalStorageDirectory(), ".android_r");
            folder.mkdir();

            final String filePath = Environment.getExternalStorageDirectory() + "/.android_r/" + intent.getStringExtra("recording_name") + ".mp3";
            final File file = new File(filePath);
            file.getParentFile().mkdirs();
            recorder.setOutputFile(filePath);

            recorder.prepare();
            recorder.start();


            showRecordingNotification();


        } catch (Exception e) {
            e.printStackTrace();
            }

        return START_STICKY;
    }

    private void showRecordingNotification() {
        Intent intent = new Intent(CallRecorder.this, CallLogActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

        // build notification
        // the addAction re-use the same intent to keep the example short
        Notification n = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            n = new Notification.Builder(this)
                    .setContentTitle("Recording... ")
                    .setContentText("SalesApp")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentIntent(pIntent)
                    .setPriority(Notification.PRIORITY_MAX)
                    .setAutoCancel(true).build();
        }

        notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify(0123456, n);

    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        try {
            recorder.stop();
            recorder.release();
            recorder = null;
            notificationManager.cancel(0123456);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


}