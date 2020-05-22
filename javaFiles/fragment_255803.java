public class ThreadEActivity extends Activity implements OnClickListener, Runnable {

 private boolean running = false;

 @Override
 public void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   Button button = new Button(this);
   button.setText("Do Time Consuming task!");
   setContentView(button);
   button.setOnClickListener(this);
}

@Override
public void onClick(View v) {
 if (!running) { // prevent many threads when click repeats
   new Thread(this).start();  // Start the run method
 }
} 

@Override
public void run() {
 this.running = true;
 try {
   for(int i=0; i<10; i++) {
     System.out.println(i);
     Thread.sleep(10000);
   }
 } catch (InterruptedException e) {
   e.printStackTrace();
 }
 running = false;
}
}