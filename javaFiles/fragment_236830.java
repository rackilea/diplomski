for (Button btn : buttonsList) {
    for (Circle c : circles) {
        if (btn.getBoundsInParent().intersects(b.getBoundsInParent())) {
            System.out.println("Colision");
        }
    }
}