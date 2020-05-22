for (ImageHolder ih : imageHolderList) {
    if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
        if (mouseX >= ih.getX() && mouseX < (ih.getX() + ih.getWidth())
                && mouseY >= ih.getY() && mouseY < (ih.getX() + ih.getWidth())) {
            doSomething();
    }
}