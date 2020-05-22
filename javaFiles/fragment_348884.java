void printEachPath(currentRoot, stack) {
    if (currentRoot == null) return;

    stack.push(currentRoot.name);
    print stack;

    printEachPath(currentRoot->next, stack);

    print stack; 
    stack.pop(currentRoot.name);
}