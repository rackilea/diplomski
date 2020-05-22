public class ClassA extends CommonClass<Comments> {
    @Override
    void send(List<Comments> commentsList) {
        // do stuff
    }
}

public class ClassB extends CommonClass<Post> {
    @Override
    void send(List<Post> postList) {
        // do stuff
    }
}