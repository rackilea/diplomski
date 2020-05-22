LinearLayout linearLayout = (LinearLayout) eventView.findViewById(R.id.eventLinearLayout);

for (int i = 0; i < partEvents.length; i++) {

    TextView viewEvent = new TextView(getActivity());

    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    params.setMargins(left, top, right, bottom); 
    viewEvent.setLayoutParams(params);

    // rest of your code

    linearLayout.addView(viewEvent);
}