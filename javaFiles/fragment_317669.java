ArrayList<YourModelClass> list;
 Context context;

 //Pagination
public void updateList(ArrayList<YourModelClass> list) {
    this.list.addAll(list);
    this.notifyDataSetChanged();
}