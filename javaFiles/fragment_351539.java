public class DatePickerDialogFragment extends DialogFragment implements OnDateSetListener {
    DatePickerDialog dp;
    DatePickerDialogFragmentListener mListener;
    final Calendar mCalendar;

    public DatePickerDialogFragment(){
        calendar = Calendar.getInstance();
    }

    @Override
    public void onAttach(Activity activity) {
        if (activity instanceof DatePickerDialogFragmentListener) {
            mListener = (DatePickerDialogFragmentListener) activity;
        } else {
            throw new IllegalArgumentException("The Activity hosting this " 
                    + "Fragment must implement DatePickerDialogFragmentListener";
        }
    }

    @Override
    public void onDetach() {
        mListener = null;
    }

    private void fireOnOkClicked () {
        if (mListener != null) {
            mListener.onOkClicked();
        }
    }

    private void fireOnCancelClicked () {
        if (mListener != null) {
            mListener.onCancelClicked();
        }
    }

    public void setInitialDate(int year, int month, int day){
        calendar.set(year, month, day);
    }

    public interface DatePickerDialogFragmentListener {
        public void okClicked(DatePicker datePicker, int year, int month, int day);
        public void cancelClicked(); 
    }
}