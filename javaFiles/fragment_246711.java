private int runs = 0;

public void setRunsOneMore() {
    runs++;
}

    public void setRunsOneLess() {
    runs--;
}

public Collection<Comment> getCommentCollection() {
    commentCollection = movie.getCommentCollection();
    Collection[] com = split((List<Comment>) commentCollection,4);
    try{
        return com[runs];
     } catch(ArrayIndexOutOfBoundsException e) {
       runs = 0;
      }
    return com[runs];
}

public Collection[] split(List<Comment> list, int size){

     int numBatches = (list.size() / size) + 1;
     Collection[] batches = new Collection[numBatches];
     Collection<Comment> set = commentCollection;

     for(int index = 0; index < numBatches; index++) {
         int count = index + 1;
         int fromIndex = Math.max(((count - 1) * size), 0);
         int toIndex = Math.min((count * size), list.size());
         batches[index] = list.subList(fromIndex, toIndex);
     }

     return batches;
 }