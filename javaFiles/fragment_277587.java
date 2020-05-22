for (i = 1; prefs.getString("mClass"+i, null) != null; i++ ){

    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
    ViewGroup.LayoutParams.MATCH_PARENT,
    ViewGroup.LayoutParams.WRAP_CONTENT);
    params.setMargins(0, i*10, 0, 0);
    Schedule_Class mClass = new Schedule_Class(getActivity(), "Math");
    Container.addView(mClass, params);
}