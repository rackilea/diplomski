//import android.app.Fragment;
import android.support.v4.app.Fragment
public class CalendarFragment extends Fragment
{
    static Context mContext      = null;                   //member variable
    ...

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
{
    mContext = this.getActivity();                         //set mContext
    ((Activity) mContext).startManagingCursor(notesCursor);//cast to Activity
    ...