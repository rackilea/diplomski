//This will add all the items in the adapter's list
       public  void addAllItems(List<CommentData> items) {
                model.addAll(items);
                notifyDataSetChanged();
            }

//In Adapter's Constructor do the following changes
 public CommentsListAdapter(Context context, List<CommentData> model) {
        this.context = context;
        this.model = new ArrayList<>;
    }