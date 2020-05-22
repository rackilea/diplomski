@Override
public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
    View v = inflater.inflate(R.layout.fragment_patient, parent, false);
    myDB = new DatabaseHelper(getActivity());
    editName = (EditText)v.findViewById(R.id.name_text);
    editFamilyname = (EditText)v.findViewById(R.id.familyname_text);
    editDob = (EditText)v.findViewById(R.id.date_text);
    editAddress = (EditText)v.findViewById(R.id.address_text);
    editPhonenb = (EditText)v.findViewById(R.id.phone_text);
    editEmail = (EditText)v.findViewById(R.id.email_text);
    btnSave = (Button)v.findViewById(R.id.save_button);
    radioG = (RadioGroup)v.findViewById(R.id.myRadioGroup);

    //remove from here:
    /*
    int selectedId = radioG.getCheckedRadioButtonId();
    if(selectedId != -1) {    
           selectedRadioButton = (RadioButton)v.findViewById(selectedId);
    }
    */

    AddData();

    return v;
}