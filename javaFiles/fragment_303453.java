public void updateCommentList(JSONObject commentsJson, int position) {
     // does not exist you might create something 
     //like that in your Adapter class
     commentListAdapter.updateItem(commentsJson,position); 
     commentListAdapter.notifyDataSetChanged();
}