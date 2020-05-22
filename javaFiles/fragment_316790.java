public class ManualControlsFragment extends Fragment {
    private TimePicker tp;
    private Calendar calendar;
    long pickedTimeInMillis;
    long timeDifference;
//some Fragment methods
    Handler mHandler = new Handler(Looper.getMainLooper());

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_manual_controls, container, false);
        tp = (TimePicker) view.findViewById(R.id.lightTimePickerStart);
        tp.setIs24HourView(true);
        calendar = Calendar.getInstance();
        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                calendar.set(Calendar.MINUTE, minute);
                calendar.set(Calendar.SECOND, 0);
                pickedTimeInMillis = calendar.getTimeInMillis();
                // at this point get the current time
                Calendar cal = Calendar.getInstance();
                // now calculate the difference as the user actually selected a time
                timeDifference = pickedTimeInMillis - cal.getTimeInMillis();
                mHandler.removeMessages(0);
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //Do something here
                        Toast.makeText(getActivity().getApplicationContext(), "Bulb is now on", Toast.LENGTH_LONG).show();
                    }
                }, timeDifference);
            }
        });
        return view;
    }
}