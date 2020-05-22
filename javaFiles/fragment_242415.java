public class Word
{
String dname;

public Word()
{
    //default constructor
}

public Word(String dname) {
    this.dname=dname;
}

/*public void setDiaryName(String dname)
{
    this.dname=dname;
}*/

public String getDiaryName()
{
    return dname;
}
}



//the custom adapter

public class ContentAdapter extends ArrayAdapter<Word>
{
    Display d;
    public ContentAdapter(Context context, ArrayList<Word>title)

{
    super(context, 0, title);
}

public View getView(int position, View convertView, ViewGroup parent) {

    // Check if the existing view is being reused otherwise inflate the view

    View listItemView = convertView;

    if (listItemView == null) {

        listItemView = LayoutInflater.from(getContext()).inflate(
                R.layout.contents, parent, false);

    }

    Word w = getItem(position);

    TextView mt = (TextView) listItemView.findViewById(R.id.exp);

    mt.setText(w.getDiaryName());

    mt.setVisibility(View.VISIBLE);

    return listItemView;
}
}




//the fragment in which list of diaries is displayed
public class HistoryFragment extends Fragment 
{
 Context context;

    Word di;
    ListView lv;
    DatabaseReference reference;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    public HistoryFragment(){
    //default constructor
    }

//The following method will get the context from the activity to which the fragment is attached 
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }
@Nullable
@Override
public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
{
    final View view = inflater.inflate(R.layout.scrolllist, container, false);

    String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
    DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference uidRef = rootRef.child("image").child(uid);
    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            //List<String> cities = new ArrayList<>();
            final ArrayList<Word> cities = new ArrayList<>();
            for(DataSnapshot ds : dataSnapshot.getChildren()) {
                String cityName = ds.getKey();
                cities.add(new Word(cityName));
            }
            ListView listView = (ListView)view.findViewById(R.id.list_of_ds);
            ContentAdapter arrayAdapter = new ContentAdapter(context,cities);
            listView.setAdapter(arrayAdapter);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
            //Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
        }
    };
    uidRef.addListenerForSingleValueEvent(valueEventListener);
    return view;
}
}