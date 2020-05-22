public class MyMemo {
    MyMemo(MyMemo memo)
    {
       this.commentText = memo.getCommentText();
       this.imageUriList = new ArrayList<>();
       for (Uri uri : memo. getImageUriList())
       {
           this.imageUriList.add(new Uri(uri));
       }
    }
    // rest of your code
}