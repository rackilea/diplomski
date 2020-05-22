import javax.xml.bind.Marshaller;

public class DepthListener extends Marshaller.Listener {

    private int targetDepth;
    private int currentDepth = 0;

    public DepthListener(int depth) {
        this.targetDepth = depth;
    }

    @Override
    public void beforeMarshal(Object source) {
        currentDepth++;
    }

    @Override
    public void afterMarshal(Object source) {
        currentDepth--;
    }

    public boolean isMarshalDepth() {
        return currentDepth <= targetDepth; 
    }

}