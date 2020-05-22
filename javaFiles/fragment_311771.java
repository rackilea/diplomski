public class PagerActivity extends AppCompatActivity implements EventFragment.OnEventSelectedListener{

    // ...

    // In order to receive event callbacks from the fragment, the activity that
    // hosts it must implement the interface defined in the fragment class.
    //For example, the following activity implements the interface from the above example.

    public void onEventSelected(int position) {
        // ...
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        if (fragment instanceof EventFragment) {
            EventFragment eventFragment = (EventFragment) fragment;
            eventFragment.setOnEventSelectedListener(this);
        }
    }
}