public class Circle_Perimeter extends Fragment
{
    EditText edtxt;
    Button btn;
    TextView txt;

    public static Circle_Perimeter newInstance()
    {
        Circle_Perimeter fragment = new Circle_Perimeter();
        return fragment;
    }

    public Circle_Perimeter()
    {
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_circle__perimeter,container,false);

        edtxt = (EditText)rootView.findViewById(R.id.editText);
        btn = (Button)rootView.findViewById(R.id.button6);
        txt = (TextView) rootView.findViewById(R.id.textView6);

        //Initially set it as disabled
        btn.setEnabled(false);

        //Add textWatcher to notify the user
        edtxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //Before user enters the text
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //On user changes the text
                if(s.toString().trim().length()==0) {
                    btn.setEnabled(false);
                    Toast.makeText(getActivity(), "Text can not be empty..",
                            Toast.LENGTH_SHORT).show();
                } else {
                    btn.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                //After user is done entering the text

            }
        });

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //do your final job here
            }
        });

        return rootView;
    }
}