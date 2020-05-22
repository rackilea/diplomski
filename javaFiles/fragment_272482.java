public class MainActivity extends Activity {

@Override
protected void onCreate(final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
}

interface Command {
    void execute(String peerId, JSONObject payload) throws JSONException;
}

class CreateOfferCommand implements MainActivity.Command {

    @Override
    public void execute(String peerId, JSONObject payload) throws JSONException {

    }
}
}