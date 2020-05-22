static StringBuilder findPath (Node root , int data_to_be_found)
{
    StringBuilder path = new StringBuilder();

    if(root==null)
        return path;

    Node current_node = root;

    while(current_node != null)
    {
        if(path.size() > 0)
            path.append(" -> ");

        path.append(current_node.data);

        if(current_node.data == data_to_be_found)
            return path;

        if(data_to_be_found > current_node.data)
            current_node = current_node.right;
        else
            current_node = current_node.left;

    }

    return path;
}