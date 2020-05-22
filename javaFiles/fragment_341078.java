private Context activityContext;

@Override
public void onAttach(@NonNull Context context) {
    super.onAttach(context);
    activityContext = context;
}

@Override
public void onDetach() {
    super.onDetach();
    activityContext = null;
}