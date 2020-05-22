public static void removeAll(Node node) 
    {
        for(Node n : node.getChildNodes())
        {
            if(n.hasChildNodes()) //edit to remove children of children
            {
              removeAll(n);
              node.removeChild(n);
            }
            else
              node.removeChild(n);
        }
    }
}