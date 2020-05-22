@Override
public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
    if (mOnDateChosenListener != null) {
        mOnDateChosenListener.onDateChosen(year, monthOfYear, dayOfMonth);
    }
}