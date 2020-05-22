public class FragmentOne extends Fragment implements View.OnClickListener{

    public FragmentOne() {}
    View rootview;
    TextView matchStatus;

    @Override
    public void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_one, container, false);

        Button matchButton = (Button)rootview.findViewById(R.id.button_match);
        matchButton.setOnClickListener(this);


        return rootview;
    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.button_match:
                matchStatus = (TextView)rootview.findViewById(R.id.textView_matchStatus);

                matchStatus.setText("sup");
                break;
        }
    }