//member functions
private int shape_length = 300;
private float total_time = 0f;

//inside render loop
public void render(float deltaTime){
total_time += deltaTime;
if(total_time >= 3.0f){
    //add 1 to length every 3 seconds
    shape_length += 1;
    total_time = 0.f;
}
shapeRenderer.begin(ShapeType.FilledRectangle);
shapeRenderer.setColor(Color.RED);
shapeRenderer.filledRect(0, 0, shape_length, 20);
shapeRenderer.end();
//fun times here
}