private void refreshYourAdapter(final ArrayList<Recipedetails> items) {
//this is what I meant. The error clearly states you are not updating the adapter on the UI thread
runOnUiThread(new Runnable() {
public void run() {
_itemListAdapter.refreshAdapter(items);
}
});
}