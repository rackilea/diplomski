public class firstpage extends Fragment {
    Button button1,button2,button3,button4,button5,button6;
    View mRootView; // declare your rootview as global variable


    public firstpage() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //remove init buttons from here, because the view is not yet created
    }


    public void addListenerOnButton() {

        final Context context = getActivity().getApplicationContext();

        button1 = (Button) mRootView.findViewById(R.id.button1);// here i make the change

        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intent = new Intent(context, page.class);
                startActivity(intent);

            }

        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.first_page, container, false);


        addListenerOnButton();// add your listeners here

        return rootView;
    }