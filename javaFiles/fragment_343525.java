@Override
public void onAttach(Context context) {
    super.onAttach(context);
    if(context instanceof Activity) {
        MainActivity activity = (MainActivity) context;
        activity.onSectionAttached(1);
    }
}