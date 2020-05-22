public class EventFragment extends Fragment {
    OnEventSelectedListener callback;

    public void setOnEventSelectedListener(OnEventSelectedListener callback) {
        this.callback = callback;
    }

    // This interface can be implemented by the Activity, parent Fragment,
    // or a separate test implementation.
    public interface OnEventSelectedListener {
        public void onEventSelected(int position);
    }

    // ...
}