public interface ISender<T> {
   void send(List<T> al);
}

public class CommentSender implements ISender<Comment> {
    @Override
    void send(List<Comment> commentsList) {
        // do stuff
    }
}

public class PostSender implements ISender<Post> {
    @Override
    void send(List<Post> postList) {
        // do stuff
    }
}