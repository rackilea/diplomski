@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
     mDateButton = (Button)v.findViewById(R.id.crime_date);
     mCrime.setDate(DateFormat.getDateInstance(DateFormat.FULL));
     mDateButton.setText(mCrime.getDate().format(new Date()));
     mDateButton.setEnabled(false);
...