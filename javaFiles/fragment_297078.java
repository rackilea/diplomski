public class FormsListFragment extends Fragment {

private DatabaseReference formsRef;
private FormsAdapter adapter;
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View  view = inflater.inflate(R.layout.fragment_forms_list, container, false);
    /**/
    RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.recycler_view);
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    adapter=new FormsAdapter();
    recyclerView.setAdapter(adapter);
    formsRef= FirebaseDatabase.getInstance().getReference().child("forms");
    formsRef.addChildEventListener(new ChildEventListener() {
        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
            /*add data in adapter one by one if isPassedInspection true*/
            String itemKey=dataSnapshot.getKey();
            UserForm userForm=dataSnapshot.getValue(UserForm.class);
            if (userForm.isPassedInspection())
                adapter.addAFormItem(itemKey,userForm);
        }

        @Override
        public void onChildChanged(DataSnapshot dataSnapshot, String s) {
              /*when something change in data then add in adapter if isPassedInspection true*/
            String itemKey=dataSnapshot.getKey();
            UserForm userForm=dataSnapshot.getValue(UserForm.class);
            if (userForm.isPassedInspection())
                adapter.addAFormItem(itemKey,userForm);
        }

        @Override
        public void onChildRemoved(DataSnapshot dataSnapshot) {

        }

        @Override
        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });
    return view;
}}