public class BlankFragment extends Fragment {

    private RecyclerView recyclerView;

    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv);
        return view;
    }
}