aspect PointObserving {
    private Vector Point.observers = new Vector();

    public void Point.addObserver(Point p, Screen s) {
        observers.add(s); //Legal to access observers here
    }
    public void Point.removeObserver(Point p, Screen s) {
        observers.remove(s); //Legal to access observers here
    }

    //Rest remains same as before.
}