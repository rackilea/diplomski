public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

  private DatePickerListener mListener;

  public interface DatePickerListener {
    void onDialogFinishInitialized();
  }

  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    DatePickerDialog dpd = new DatePickerDialog(getActivity(),
            R.style.MyDialogTheme, this, year, month, day);

    // you need to inform the activity when Dialog has finish
    // initialized.
    mListener.onDialogFinishInitialized();

    return dpd;
  }

  ...

  // Need to add the activity as the listener.
  @Override 
  public void onAttach(Activity activity) {
    super.onAttach(activity);
    // This makes sure that the container activity has implemented
    // the listener interface. If not, it throws an exception
    try {
      mListener = (DatePickerListener) activity;
    } catch (ClassCastException e) {
      throw new ClassCastException(activity.toString() + " must implement DatePickerListener");
    }
  }

  ...

}