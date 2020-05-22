import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sukhvir on 17/04/2015.    
*/
public class events extends android.support.v4.app.Fragment {
    public events(){}
    private static final int ARG_SECTION_NUMBER = 5;
    public View onCreateView(LayoutInflater inflater,
                         ViewGroup container, Bundle savedInstanceState) {
        /**
         * Inflate the layout for this fragment
         */
        return inflater.inflate(
            R.layout.events, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(
            ARG_SECTION_NUMBER);
    }
}