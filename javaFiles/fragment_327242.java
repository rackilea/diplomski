// A class where your ArrrayAdapter.
public class MainActivity extends AppCompatActivity implements AsyncTaskMessage.OnMessageListener {

    //.. 

    public void displayMessage() {
        MessageCentre centre = new MessageCentre(this);
        centre.getMessages(1); 
    }

    @Override
    public void messageCallback(ArrayList<String> messageList) {
        Log.i("MainActivity", "Response: " + messageList.toString());
        ArrayAdapter a = new ArrayAdapter(getApplicationContext(),R.id.item_layout, messageList);
        listview.setAdapter(a);
    }
}