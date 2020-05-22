while (!Stack.empty()):
    current_node = Stack.pop();
    foreach node in all_nodes:
        if current_node[1] == node[0] and node.not_visited_yet(): Stack.push(node)
    // now we have the neighbors for this current_node pushed into the Stack
    // Note that node.not_visited_yet() could be a function that keeps track of nodes
    // that you already visited somehow (a map from node to boolean perhaps?)