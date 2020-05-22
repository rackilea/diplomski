@Override
public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
     //int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
       int swipeFlags = ItemTouchHelper.START;
       return makeMovementFlags(dragFlags, swipeFlags);
}