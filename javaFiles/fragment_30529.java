public class FragmentSettings extends PreferenceFragment {

    RadioGroup radioGroup;
    RadioButton radioButton1,radioButton2,radioButton3;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getActivity().setTitle(R.string.fr5);
        View rv = inflater.inflate(R.layout.fragment_settings, container, false);
        radioGroup = (RadioGroup) rv.findViewById(R.id.radioGroup);
        radioButton1 = (RadioButton) rv.findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) rv.findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) rv.findViewById(R.id.radioButton3);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        editor = sharedPreferences.edit();

        // Required to get the checked RadioButton id
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int selectedPosition;

                switch (checkedId) {
                    case R.id.radioButton1:
                        selectedPosition = 1;
                        break;
                    case R.id.radioButton2:
                        selectedPosition = 2;
                        break;
                    case R.id.radioButton3:
                        selectedPosition = 3;
                        break;
                    default:
                        selectedPosition = 1;
                        break;
                }

                // Store in SharedPreferences
                editor.putInt("SELECTED_POSITION", selectedPosition);
                editor.commit();
            }
        });

        return rv;
    }
}