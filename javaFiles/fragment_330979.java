public void displayPath(Node answer) {
    if (answer.getParent() == null) {
        return;
    }

    displayPath(answer.getParent());

    System.out.println(answer);
}