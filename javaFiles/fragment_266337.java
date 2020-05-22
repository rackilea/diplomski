public class LocationListAdapter extends ArrayAdapter<TwoString> {

   private final List<TwoString> values;
   private final Context context;
   private ListItemListener listener = null;

public LocationListAdapter( Context c, 
    int textViewResourceId,
    List<TwoString> v) {

    super(c, R.layout.location_item, v );
    context = c;
    values = v;
    }
}