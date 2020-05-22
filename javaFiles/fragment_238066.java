if (direction == ItemTouchHelper.LEFT) {    //if swipe left
    activeSubs.remove(position);
    saveListToSharedPrefs();
    updateCost();

    // Only calling notifyDataSetChanged should do the job
    adapter.notifyDataSetChanged();
}