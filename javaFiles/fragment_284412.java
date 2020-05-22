private void printPrefix(Node<?> node){

        //If node is null, reached end of chain, return to caller
        if (node==null) {
            return;
        }

        //Print self
        System.out.print(node.getValue());
        System.out.print(" ");

        //Print all children
         for (Source child : node.children) //changed for multiple
{
    printPrefix(child);
}

        return;
    }