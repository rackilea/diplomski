public static void main(String[] args) {
    Circle c = new Circle();
    Quadrat q = new Quadrat();
    Paint p = new Paint();  // **** ANOTHER new Paint is here, and it gets goodies
    p.figuresList.add(c);
    p.figuresList.add(q);

    // but is never added to a JFrame and is never displayed.

    GUI.Configuration();
}