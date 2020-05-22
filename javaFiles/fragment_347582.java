@Override
public void onAttach(Activity activity) {
    super.onAttach(activity);
    try {
        mListener = (DateListener) activity;
    } catch (ClassCastException e) {
        throw new ClassCastException(activity.toString() + " must implement DateListener");
    }
}

@Override
public void onDetach() {
    super.onDetach();
    mListener = null;
}