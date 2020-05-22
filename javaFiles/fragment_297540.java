String[] chartNames = getActivity().getResources().getStringArray(R.array.chart_names);

if (chartNames[0].equals("abc")) {
  Log.v("msg", "yes");
}else{
  Log.v("msg", "no");
}