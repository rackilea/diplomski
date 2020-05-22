public class OutboxFragment extends Fragment {


ArrayList<String> arrayList = new ArrayList<>();
ArrayAdapter<String> arrayAdapter;
public String getusername;
public String uid;
FirebaseAuth firebaseAuth;

public OutboxFragment() {
    // Required empty public constructor
}


@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_outbox, container, false);

    firebaseAuth = FirebaseAuth.getInstance();
    uid = firebaseAuth.getCurrentUser().getUid();

    dapatdatauser(uid);
    // Inflate the layout for this fragment
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    Query query = reference.child("Sendmail").orderByChild("username_from").equalTo("rezkysaputra96");
    ListView listView = (ListView) view.findViewById(R.id.listview);
    arrayAdapter = new ArrayAdapter<String>( getActivity().getApplicationContext(), android.R.layout.simple_list_item_1,arrayList);
    listView.setAdapter(arrayAdapter);

    query.addChildEventListener(new ChildEventListener() {
        @Override
        public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            Map data = (Map ) dataSnapshot.getValue();
            String name = (String) data.get("perihal");
            arrayList.add(name);
            arrayAdapter.notifyDataSetChanged();
        }

        @Override
        public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

        }

        @Override
        public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

        }

        @Override
        public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });


    return view;

}

public void dapatdatauser(String iduser){
    // Mendapatkan DataUsers Berdasarkan uid sesuai login
    DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
    DatabaseReference query = reference.child("DataUsers").child(iduser);
    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            // Memasukkan data kedalam variabel username
            getusername = dataSnapshot.child("username").getValue(String.class);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };
    query.addListenerForSingleValueEvent(valueEventListener);
}