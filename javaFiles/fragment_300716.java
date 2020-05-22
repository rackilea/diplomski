commonAncestor.setOnMouseEntered(evt -> {
    Node n = evt.getPickResult().getIntersectedNode();
    while (n != commonAncestor) {
        if (checkNode(n)) {
            label.setCursor(Cursor.HAND);
            label.setText("Hovered!");
            return;
        }
        n = n.getParent();
    }

    label.setCursor(Cursor.MOVE);
    label.setText("Bored");
});