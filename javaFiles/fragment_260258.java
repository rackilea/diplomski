public class DataView extends Fragment implements SensorListener {
    // or however its setup
    @Override public void onUpdate(String incomingMessage) {
        // Do whatever you need - use runOnUiThread if touching views
    }
}