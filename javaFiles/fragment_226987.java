FragmentManager fragmentManager = getActivity().getFragmentManager();
DatePickerFragment datePickerFragment = new DatePickerFragment();
datePickerFragment.addOnDateChosenListener(new OnDateChosenListener() {
    public void onDateChosen(int year, int month, int day) {
        // use values to change EditText value
    }
}
datePickerFragment.show(fragmentManager, "datepicker");