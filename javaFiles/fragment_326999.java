// this is what controls whether you use a Fragment from the support library
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SimpleActivity extends AppCompatActivity
//      TODO: delete "implements SimpleFragment.OnFragmentInteractionListener" from this
//      line (leave the '{')
        implements SimpleFragment.OnFragmentInteractionListener {

    private static final String TAG = SimpleActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        SimpleFragment fragment = new SimpleFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
            .add(R.id.fragment_container, fragment)
            .commit();
    }

    // TODO: this entire method can be deleted
    @Override
    public void onFragmentInteraction(String message) {
        // This is where you can act on the message from the Fragment.  You would do 
        //  things that are done from an Activity or you may pass the message on 
        //  to another Fragment.
        Log.d(TAG, message);
    }
}