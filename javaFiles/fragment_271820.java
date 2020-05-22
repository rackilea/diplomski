class State {
    private volatile int x;
    public State(int y) { x = y; }
    public void setX(int y) { x = y; }
    public int getX() { return x; }
}