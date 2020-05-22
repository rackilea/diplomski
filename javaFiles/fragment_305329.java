import java.util.ArrayList;
import java.util.List;

public class Node {

    public Node parent; // The parent of the current node
    public List<Node> children; // The children of the current node
    public Object info;

    public static int maxNrOfChildren; // Equal to the k-arity; 

    public Node (Object info)
    {
        this.info=info; 
        children  = new ArrayList<Node>(maxNrOfChildren);
    }

    public void addChild(Node childNode, int position)
    // You must take care so that future insertions don't override a child on i-th position
    {
        if(position>=maxNrOfChildren-1)
        {
            // Throw some error
        }

        else
        {
            System.out.println("this.children="+this.children);
            if(this.children.get(position)!=null)
            {
                // There is alerady a child node on this position; throw some error;
            }
            else
            {
                childNode.parent=this;
                this.children.set(position, childNode);
            }
        }
    }
}