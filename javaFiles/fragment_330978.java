Deque<String> steps = new ArrayDeque<>();
while (answer.getParent() != null) {
    steps.addFirst(answer.toString());
    answer = answer.getParent();
}

while (!steps.isEmpty()) {
    System.out.println(steps.removeFirst());
}