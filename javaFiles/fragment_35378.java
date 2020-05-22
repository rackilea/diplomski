//instantiate object
RectShape s = new RectShape(300.f,200.f,new Vector2(3,2));

//render loop
total_time += deltaTime;
if(total_time >= 3.0f){
    //add 1 to length every 3 seconds
    s.increaseLength();
    total_time = 0.f;
}
shapeRenderer.begin();
drawRectangle(s,shapeRenderer);
shapeRenderer.end();