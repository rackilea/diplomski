for (Node node : anchorPane.getChildren()) {
    System.out.println("Id: " + node.getId());
    if (node instanceof TextField) {
        // clear
        ((TextField)node).setText("");
    }
}