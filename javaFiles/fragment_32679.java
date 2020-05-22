public class MyTimePicker {
TimePickerDialog mTimePickerDialog;

public interface onTimeSet {
    public void onTime(TimePicker view, int hourOfDay, int minute);
}

onTimeSet mOnTimeSet;

public void setTimeListener(onTimeSet onTimeset) {
    mOnTimeSet = onTimeset;
}

public MyTimePicker(Context ctx) {
    mTimePickerDialog = new TimePickerDialog(ctx, new OnTimeSetListener() {

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            mOnTimeSet.onTime(view, hourOfDay, minute);

        }
    }, 1, 1, true);
}

public void show() {
    mTimePickerDialog.show();
}