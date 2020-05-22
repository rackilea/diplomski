public interface FragmentEventListener {
    void onFragmentChangeEvent(Fragment newFragment);
}

private FragmentEventListener listener;
public void setEventListener(FragmentEventListener listener) {
    this.listener = listener;
}