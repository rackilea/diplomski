public class GluonAndroidPlatform implements GluonPlatform {

    @Override
    public void vibrate() {
        Vibrator v = (Vibrator) FXActivity.getInstance().getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(500);
    }

}