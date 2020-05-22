@Override
public void onAttach(Context context) {
    super.onAttach(context);
    Log.d(TAG, "Entered onAttach");
    try {
        Log.d(TAG, "Trying to create new mCallback");
        //modified:
        if (context instanceof DatePickerActivity){
            mCallback = (DatePickerActivity) context; 
        }
        Log.d(TAG, "mCallback is " + mCallback);
    } catch (ClassCastException e){
        throw new ClassCastException(date.toString() + " must implement NewDate");
    }
}