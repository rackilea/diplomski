private ArrayList<DataObject> mDataset;
Context context;
//Here your list
private List<TextView> tvList = new ArrayList();

public static class DataObjectHolder extends RecyclerView.ViewHolder {

    public DataObjectHolder(View itemView) {
        super(itemView);
        setting1 = (TextView) itemView.findViewById(R.id.textView);
        setting2 = (TextView) itemView.findViewById(R.id.textView2);

       // Then you add all your TextViews to your list
       tvList.add(setting1); 
       tvList.add(setting2); 
    }
}