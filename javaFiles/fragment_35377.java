class RectShape {
private float width;
    private float height;
    private Vector2 pos;
    private Color color;
    public RectShape(float w, float h, Vector2 p){
        width = w;
        height = h;
        pos = p;
    }

    public void increaseLength(){
        width += 2.f;
    }
    //getters: getColor(), getPosition(), getWidth, getHeight()

 }