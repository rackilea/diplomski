public void mouseClicked(MouseEvent event) {  
    if ((event.getButton() == MouseEvent.BUTTON1) &&
        between(event.getX(), x, x + image.getIconWidth()) &&
        between(event.getY(), y, y + image.getIconHeight()) {

        catchCount++;
    }
}

private static boolean between(int x, int lower, int upper) {
    return (x >= lower) && (x <= upper);
}