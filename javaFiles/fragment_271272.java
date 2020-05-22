class CircularPane extends Pane {

    private final double radius;
    private final double ext_gap;
    private final double int_gap;

    public CircularPane(double radius, double ext_gap, double int_gap){
        this.radius=radius;
        this.ext_gap=ext_gap;
        this.int_gap=int_gap;

        setMinSize(2*radius, 2d*radius);
        setPrefSize(2*radius, 2d*radius);
        setMaxSize(2*radius, 2d*radius);
    }
}