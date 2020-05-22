public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    try {
        Spinner s = (Spinner) findViewById(R.id.stateselector);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(), R.array.states, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
    } catch (Exception e) {
        Toast.makeText(getActivity(), e.toString(), 1).show();
    }
}