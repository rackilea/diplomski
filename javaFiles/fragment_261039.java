public class MyActivity extends AppCompatActivity {

    private OnNumberChangeCallback callback;

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);

        if (fragment instanceof OnNumberChangeCallback) {
            callback = (OnNumberChangeCallback) fragment;
        }
    }

    // other activity methods, like onCreate() etc
}