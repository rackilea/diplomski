public class MainActivity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        // Create a ViewModel the first time the system calls an activity's onCreate() method.
        // Re-created activities receive the same MyViewModel instance created by the first activity.

        MessagesViewModel model = ViewModelProviders.of(this).get(MessagesViewModel.class);
        model.getMessages().observe(this, messagesList -> {
            // Do whatever you want with the list of messages.
        });
    }
}