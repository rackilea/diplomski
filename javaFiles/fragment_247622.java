protected FragmentActivity getActivityNonNull() {
    if (super.getActivity() != null) {
        return super.getActivity();
    } else {
        throw new RuntimeException("null returned from getActivity()");
    }
}