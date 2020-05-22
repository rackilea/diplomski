public static class MyVertex  {
    private String name;
    private int vIndex;
    private boolean visited = false;
    private int distance = 0;

    private double x;
    private double y;

    public MyVertex(String name, int vIndex) {
        this.name = name;
        this.vIndex = vIndex;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getX() {
        return x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public String getName() {
        return name;
    }