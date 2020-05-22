Activity curActivity = getActivity();
if(curActivity != null) {
    Intent intenta = StatisticsActivity.newInstance(
    /* this is where the change is -> */ curActivity, (Question)mStream.get(position));
    startActivity(intenta);
}