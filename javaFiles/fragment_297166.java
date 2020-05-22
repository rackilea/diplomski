protected void moveBall() {
    // Check boundaries

    boolean changedHorizontal = false ;

    if (x < radius || x > getWidth() - radius) {
        dx *= -1; // Change ball move direction
        changedHorizontal = true ;
    }
    if (y < radius || y > getHeight() - radius) {
        dy *= -1; // Change ball move direction
        if (changedHorizontal) {
            i++ ;
            System.out.println(i);
        }
    }

    // Adjust ball position
    x += dx;
    y += dy;
    ellipse.setCenterX(x);
    ellipse.setCenterY(y);

}