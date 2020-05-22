public class FragmentB extends Fragment {

    TextView display;
    String[] data;
    int val;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View m_view;
        m_view = inflater.inflate(R.layout.fragment_layout_b, container, false);

        display = (TextView) m_view.findViewById(R.id.textView1);
        Resources res = getActivity().getResources();
        data = res.getStringArray(R.array.titles);
        Log.d("this", "Fragment B created ");
        return m_view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub

        super.onActivityCreated(savedInstanceState);

    }

    public void changeText(int index) {
        val=getActivity().getIntent().getIntExtra("index",0);
        display.setText(data[val]);
        Log.d("this", "changing text");
    }

}