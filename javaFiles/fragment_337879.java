public enum Square {
    A1(new Point(0, 9)), 
    A2(new Point(0, 8)), 
    A3(new Point(0, 7)), 
    A4(new Point(0, 6)), 
    A5(new Point(0, 5)), 
    A6(new Point(0, 4)), 
    A7(new Point(0, 3)), 
    A8(new Point(0, 2)), 
    A9(new Point(0, 1)), 
    A10(new Point(0, 0));
    // ... The rest of the board        

    private Point point;

    private Square(Point point) {
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }        
}