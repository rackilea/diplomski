public interface Handler {
    public Class getCategory();
    public void handle(Thing item);
}

public class VideoHandler implements Handler {
    public Class getCategory() {
        return Video.class;
    }

    public void handle(Thing item) {
        if (!item instanceof getCategory()) {
            throw new IllegalArgumentException("Wrong category - can only handle Video");
        }
        Video video = (Video) item;
        // do video-things            
    }        
}