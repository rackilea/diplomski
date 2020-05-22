@Nullable
@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
View rootView =  inflater.inflate(R.layout.add_vehicle, container, false);

Spinner spinnerY = rootView.findViewById(R.id.spinnerYear);
ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.year, android.R.layout.simple_spinner_item);
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
spinnerY.setAdapter(adapter);
return rootView;
}

 @Override
public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

}

@Override
public void onNothingSelected(AdapterView<?> parent) {

}