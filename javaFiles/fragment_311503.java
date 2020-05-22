import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.softmodeler.common.CommonPlugin;
import com.softmodeler.model.OutputNode;
import com.softmodeler.service.IViewService;
import com.vaadin.data.Container.Hierarchical;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItem;

/**
 * @author Flavio Donzé
 * @version 1.0
 */
public class OutputNodeHierachical implements Hierarchical {
    private static final long serialVersionUID = 8289589835030184018L;

    /** the view service */
    private IViewService service = CommonPlugin.getService(IViewService.class);

    /** collection of all root nodes */
    private List<OutputNode> rootNodes = null;
    /** parent=>children mapping */
    private Map<OutputNode, List<OutputNode>> hierarchy = new HashMap<>();

    /**
     * constructor
     *
     * @param rootNodes collection of all root nodes
     */
    public OutputNodeHierachical(List<OutputNode> rootNodes) {
        this.rootNodes = Collections.unmodifiableList(rootNodes);

        addToHierarchy(rootNodes);
    }

    @Override
    public Collection<?> getChildren(Object itemId) {
        try {
            List<OutputNode> children = hierarchy.get(itemId);
            if (children == null) {
                OutputNode node = (OutputNode) itemId;
                children = service.getChildren(node.getNodeId(), false);

                hierarchy.put(node, children);

                // add children to hierarchy, their children will be added on click
                addToHierarchy(children);
            }
            return children;
        } catch (Exception e) {
            VaadinUtil.handleException(e);
        }
        return null;
    }

    /**
     * add each element to the hierarchy without their children hierarchy(child=>null)
     *
     * @param children elements to add
     */
    private void addToHierarchy(List<OutputNode> children) {
        for (OutputNode child : children) {
            hierarchy.put(child, null);
        }
    }

    @Override
    public boolean areChildrenAllowed(Object itemId) {
        return !((OutputNode) itemId).getChilds().isEmpty();
    }

    @Override
    public boolean hasChildren(Object itemId) {
        return !((OutputNode) itemId).getChilds().isEmpty();
    }

    @Override
    public Object getParent(Object itemId) {
        String parentId = ((OutputNode) itemId).getParentId();
        for (OutputNode node : hierarchy.keySet()) {
            if (node.getNodeId().equals(parentId)) {
                return node;
            }
        }
        return null;
    }

    @Override
    public Collection<?> rootItemIds() {
        return rootNodes;
    }

    @Override
    public boolean isRoot(Object itemId) {
        return rootNodes.contains(itemId);
    }

    @Override
    public Item getItem(Object itemId) {
        return new BeanItem<OutputNode>((OutputNode) itemId);
    }

    @Override
    public boolean containsId(Object itemId) {
        return hierarchy.containsKey(itemId);
    }

    @Override
    public Collection<?> getItemIds() {
        return hierarchy.keySet();
    }

    @Override
    public int size() {
        return hierarchy.size();
    }

    @Override
    public boolean setParent(Object itemId, Object newParentId) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean setChildrenAllowed(Object itemId, boolean areChildrenAllowed) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Item addItem(Object itemId) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object addItem() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeItem(Object itemId) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAllItems() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Class<?> getType(Object propertyId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<?> getContainerPropertyIds() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Property<?> getContainerProperty(Object itemId, Object propertyId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addContainerProperty(Object propertyId, Class<?> type, Object defaultValue) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeContainerProperty(Object propertyId) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

}