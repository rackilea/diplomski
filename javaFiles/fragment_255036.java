import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChatActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);

        LinearLayout layout = (LinearLayout)findViewById(R.id.chatWindow);

        //When you get a new message to display, you can add it at runtime like this:
        TextView message1 = new TextView(this);
        message1.setText("how are you");
        layout.addView(message1);

        //Add another message
        TextView message2 = new TextView(this);
        message1.setText("I'm fine");
        layout.addView(message2);

    }

}