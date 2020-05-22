public class MainActivity extends Activity implements SensorListener {
// or whatever your current setup is

    @Override public void onUpdate(String incomingMessage) {
        final DataView fragment = (DataView) getFragmentManager().findFragmentByTag("DataView");
        if(fragment != null){
            fragment.onUpdate(incomingMessage);
        }
    }
}