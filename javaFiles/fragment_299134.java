public class SearchVisitor implements IVisitor {

     private Integer searchId;

     public SearchVisitor(Integer searchId) {
          this.searchId= searchId;
     }

     @Override
     public void visit(NodeBase node) {
         if (node instanceof Employee) {
             if (((Employee)node).getId().equals(searchId)) {
                  System.out.println("Found the node " + node.toString() + "!");
             }
         }
     }
}