public class MainActivity extends AppCompatActivity implements ThreadFinishListener {
    // .... Other functions in your activity 

    @Override
    void onFinish() {
        // Do something when the Thread is finished and returned back to the activity
        // This is actually your callback function. 
    }
}