import javax.xml.bind.annotation.adapters.XmlAdapter;

public class RootAdapter extends XmlAdapter<Root, Root> {

    private DepthListener depthListener;

    public RootAdapter() {
    }

    public RootAdapter(DepthListener depthListener) {
        this.depthListener = depthListener;
    }

    @Override
    public Root unmarshal(Root root) throws Exception {
        return root;
    }

    @Override
    public Root marshal(Root root) throws Exception {
        if(depthListener != null && !depthListener.isMarshalDepth()) {
            return null;
        }
        return root;
    }

}