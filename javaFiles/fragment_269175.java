public class TestWidget extends AppWidgetProvider {

    @Override
    public void onEnabled(Context context) {
        super.onEnabled(context);
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
    }
}