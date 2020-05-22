for (int j = 0; j < friendsNum; j++) {
    int current = scanner.nextInt();
    while (deleted < toDeleteNum && !stack.isEmpty() && stack.peek() < current) {
        stack.pop();
        deleted++;
    }
    stack.push(current);
}
while (deleted < toDeleteNum) {
    stack.pop();
    deleted++;
}