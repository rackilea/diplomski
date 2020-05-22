public class WifivsDataDialog extends DialogFragment implements View.OnClickListener {
    private CheckBox checkBox;
    private Button button1;
    private Button button2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mainView = inflater.inflate(R.layout.wifi_dialog, container);
        checkBox = (CheckBox) mainView.findViewById(R.id.checkBox);
        button1 = (Button) mainView.findViewById(R.id.button1);
        button2 = (Button) mainView.findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                // Store the isChecked to Preference here
                SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putBoolean("DONT_SHOW_DIALOG", isChecked);
                editor.commit();

            }
        });
        return mainView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                // Do wifi stuff here
                break;
            case R.id.button2:
                // Do cellular stuff here
                break;
        }
    }
}