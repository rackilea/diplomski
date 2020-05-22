public class Booking_activity extends AppCompatActivity
implements View.OnClickListener, DatePickerFragment.DatePickerListener {
  ...
  private DatePickerFragment dFragment;
  ...
  @Override
  public void onDialogFinishInitialized() {
    // You can call the method here now
    dFragment.getFormattedDate();
  }
  ...
}