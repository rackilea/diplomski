@Override
public void onAttach(Context context) {
    super.onAttach(context);

    try {
        mCallBack = (SignUpFragmentCallBack) context;
    }
    catch (ClassCastException e) {
        throw new ClassCastException(context.toString() +
            " must implement the SignUpFragmentCallBack interface");
    }
}