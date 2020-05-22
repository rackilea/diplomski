public class FragmentLogin extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final view view = inflater.inflate(R.layout.fragment_login, container, false);

        final ValidationManager Check = new ValidationManager();
        final SessionManager Session = new SessionManager(this);

        final EditText textEmail = (EditText) view.findViewById(R.id.login_email);
        final EditText textPassword = (EditText) view.findViewById(R.id.login_pass);
        final Button buttonLogIn = (Button) view.findViewById(R.id.button_login);
        final Button buttonSignup = (Button) view.findViewById(R.id.button_signup);

        // Listen for FORGOTTEN PASSWORD click event, open ForgottenPassword Fragment //
        final Button forgottenPassword = (Button) view.findViewById(R.id.button_lost_pass);
        forgottenPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.fragment_forgotten_password);
            }
        });

    ... more code ...

        return view;

    }
}