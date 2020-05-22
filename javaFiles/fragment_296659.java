@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    sharedPreferences my_prefs getActivity().getSharedPreferences("my_pref", Context.MODE_PRIVATE);
    age_editText.setText(my_prefs.getInt("age_value", 0) + ""); //when i delete this part, it doesn't force close

    btn_calculate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {

                Int age_value = Integer.parseInt(age_editText.getText().toString());

                SharedPreferences.Editor editor = my_prefs.edit();
                editor.putInt("age_value", age_value);
                editor_bmi.commit();

            } catch (Exception e) {
                Toast.makeText(getContext(), getString(R.string.please_fill_all_inputs), Toast.LENGTH_LONG).show();
            }
        }
    });
}