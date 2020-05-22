package apps.site.components.structure.slider;

import com.adobe.cq.sightly.WCMUse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.*;
import java.util.HashMap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Simple utility class to help a Sightly component get a child node's properties
 */
public class SliderLogic extends WCMUse {


    public ArrayList<Resource> childList = new ArrayList<Resource>();


    @Override
    public void activate() throws Exception {

        String childNode = get("childNode", String.class);
        Resource childResource = getResource().getChild(childNode);

        if (childResource != null) {

            Iterator<Resource> children = getResource().listChildren();

            while (children.hasNext()) {

                Resource child = children.next();
                String parentNodeName = child.getName();

                if (parentNodeName.equals("slides")) {
                    setChildIterator(child);
                }
            }
        }
    }

    public void setChildIterator(Resource childsResourceNode) {

        Iterator<Resource> childItems = childsResourceNode.listChildren();

        while (childItems.hasNext()) {
            Resource child              = childItems.next();

            childList.add(child);
        }
    }

    public ArrayList<Resource> getChildProperties() {

        System.out.println("\n items list " + childList);
        return childList;
    }
}