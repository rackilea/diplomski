@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
     mDateButton = (Button)v.findViewById(R.id.crime_date);
     mDateButton.setText(android.text.format.DateFormat.format("EEEE, MMM dd yyyy", new java.util.Date()));
     mDateButton.setEnabled(false);
...