@Override
public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof yourFragmentListener) {
        mListener = (yourFragmentListener) context;
    } else {
        // Error Code
    }
}