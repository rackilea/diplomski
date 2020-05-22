public class FragmentReportHauls extends Fragment {

    public static final String PAGE_TITLE = "Shift";

    private final String unitID;

    public FragmentReportHauls() {
    }

    // Here I want to get unitID
    public static FragmentReportHauls newInstance(String unitID) {
        FragmentReportHauls fragment = new FragmentReportHauls();
        this.unitID = unitID;
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_report_hauls, container, false); 


        return view;
    }
}
}