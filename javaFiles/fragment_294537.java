Queue<SearchOperationRequest> queue = new LinkedList<>();
Deque<SearchOperationRequest> comparatorStack = new LinkedList<>();

if (root == null || !root.isComparator()) return;
queue.add(root);
while(!queue.isEmpty()){
    SearchOperationRequest node = queue.poll();
    comparatorStack.push(node);
    if(node.left != null && node.left.isComparator()) queue.add(node.left);
    if(node.right != null && node.right.isComparator()) queue.add(node.right);
}

Queue<Specification> specQueue = new LinkedList<>();
while(!comparatorStack.isEmpty()){
    SearchOperationRequest comparator = comparatorStack.pop();
    // reverse operand order so already computed values are polled correctly
    Specification operand2; 
    SearchOperationRequest pointer = comparator.getRight();
    if(pointer.isTreeLeaf()) {
        operand2 = converter.apply(new SpecificationSearchCriteria(pointer.getColumn(), pointer.getCondition(), pointer.getValue()));
    } else {
        operand2 = specQueue.poll();
    }
    Specification operand1; 
    pointer = comparator.getLeft();
    if(pointer.isTreeLeaf()) {
        operand1 = converter.apply(new SpecificationSearchCriteria(pointer.getColumn(), pointer.getCondition(), pointer.getValue()));
    } else {
        operand1 = specQueue.poll();
    }
    if (comparator.equals(SearchComparator.AND)) {
        specQueue.add(Specification.where(operand1).and(operand2));
    } else if (comparator.equals(SearchComparator.OR)) {
        specQueue.add(Specification.where(operand1).or(operand2));
    }
} 

return specQueue.poll();