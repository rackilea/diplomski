public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.CustomViewHolder> {
    ...
    public void setItems(List<WallItem> items) {
        this.wallItemList = wallItemList;
        notifyDataSetChanged();
    }

}