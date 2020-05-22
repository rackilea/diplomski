//Make your class named CUstomDialogClass
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.Button;

    public class CustomDialogClass extends Dialog{

    public Activity c;
    public Dialog d;
    public Button yes, no;

    public CustomDialogClass(Activity a) {
    super(a);
    // TODO Auto-generated constructor stub
    this.c = a;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.customdialog);

    }

    }

In your MainActivity, place this code in your onCreate() method:


    Button button = (Button)findViewById(R.id.yourid);
    button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                final CustomDialogClass dialog = new CustomDialogClass(MainActivity.this);
        dialog.setTitle("Your Title");
        dialog.show();

        final Timer time = new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                dialog.dismiss();
            }
        }, 5000);

            }
        });