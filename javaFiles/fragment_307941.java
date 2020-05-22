public class EditFragment extends Fragment {

    EditText ed;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmentlayout,container,false);

        return v;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        ed = (EditText) getView().findViewById(R.id.editText1);
        ed.setOnClickListener(new  OnClickListener()
        {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
              TimePickerFragment newFragment = new TimePickerFragment();
              newFragment.show(getFragmentManager(), "timePicker");
            }

        });
    }
    public void setEdittextvalue(String value) {
        // TODO Auto-generated method stub
        ed.setText(value);

    }
}