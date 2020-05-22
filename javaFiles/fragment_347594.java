public class Tree{
       ... 
    public boolean recursiveNodeOperation(NodeOperation operation) {
       if(!operation.forAll(this)) return false;
       for(Tree child : children) 
            if(! child.recursiveNodeOperation(operation)) 
                return false
       return true ;

      } 
    } 



root.recursiveNodeOperation(overTwenty); //will return true if all the nodes of the Tree starting from root are lower than 20