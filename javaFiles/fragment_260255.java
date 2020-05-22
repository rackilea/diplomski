public static TimePickerFragment instance(int viewId){
    TimePickerFragment fragment = new TimePickerFragment();
    Bundle b = new Bundle();
    b.putInt("KEY_ID", viewId);
    fragment.setArguments(b);
    return fragment;
}