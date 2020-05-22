function DFS (Stack, current_node): // recursive
    current_node = Stack.pop();
    foreach node in all_nodes:
        if current_node[1] == node[0] and node.not_visited_yet(): Stack.push(node)
    if not Stack.empty:
        next_node = Stack.pop()
        return DFS(Stack, next_node)