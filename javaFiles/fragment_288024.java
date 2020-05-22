public void onParseFinished(final List<FootballModel> result) {
    //todo: fill data from result into your adapter
    //todo: inform your adapter with adapter.notifyDataSetChanged()
    //info: the adapter will inform the ui to update the view

    //example code below
    adapter.addAll(result);
    //not sure if this is really needed. Try with / without this 
    adapter.notifyDataSetChanged();
}