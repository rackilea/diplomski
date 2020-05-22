public class MainActivity extends Activity implements  MainActivity.Command{

@Override
protected void onCreate(final Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
}

@Override
public void execute(String peerId, JSONObject payload) throws JSONException {

}

interface Command {
    void execute(String peerId, JSONObject payload) throws JSONException;
}
}