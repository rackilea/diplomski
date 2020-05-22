public class Supplier_Home extends Fragment {
private static final String TAG = "Supplier_Home";
View view;
@Nullable
@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup 
container, @Nullable Bundle savedInstanceState) {
    view = inflater.inflate(R.layout.supply__home__po, container, false);
    Button pOrders=(Button) view.findViewById(R.id.pOrders);
    pOrders.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Log.d(TAG, "onClick: Clicked login1.");
        Intent intent = new Intent(getContext(), Login.class);
    }
    });
   return view;
  }
}