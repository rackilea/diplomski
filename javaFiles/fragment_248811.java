View view;

@Nullable
@Override

public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



    view = inflater.inflate(R.layout.fragment_login,container,false);
    return view;


}

@Override
public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

    Button b = view.findViewById(R.id.Loginbutton);
    EditText e = view.findViewById(R.id.user);
    EditText e1 = view.findViewById(R.id.pass);
    b.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent l = new Intent(getActivity(), AfterLogin.class);
            startActivity(l);
        }
    });
    super.onViewCreated(view, savedInstanceState);
}

public LoginFragment() {}