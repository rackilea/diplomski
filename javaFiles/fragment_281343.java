// record this value before making any changes to the existing list
int curSize = adapter.getItemCount(); // replace this line with wherever you get new records
ArrayList<Post> newItems = Post.createPostsList(20);
// update the existing list
items.addAll(newItems);
// curSize should represent the first element that got added
// newItems.size() represents the itemCount
adapter.notifyItemRangeInserted(curSize, newItems.size());