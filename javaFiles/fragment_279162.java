public static class AddressFragment extends Fragment {

    OnAddressListener mListener;

    // Container Activity must implement this interface
    public interface OnAddressListener {
        public void onAddressChanged(String address);
    }

    // Use : mListener.onAddressChanged(address)

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnAddressListener ) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnAddressListener");
        }
    }
}