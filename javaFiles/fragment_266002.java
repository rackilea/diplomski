//problem:
     private static int page;
   //solution:
     private int page;

public class SingleCard extends Fragment {
    public static SingleCard newInstance ( int sent_in_position ) {
        SingleCard fragmentFirst = new SingleCard ();
        Bundle args = new Bundle();
        args.putInt("position", sent_in_position);
        fragmentFirst . setArguments(args);
        return fragmentFirst;
    }

@Override
public void onCreate (Bundle savedInstanceState ) {
    super.onCreate(savedInstanceState);
    page = getArguments().getInt("position", 0);
}