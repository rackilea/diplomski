ExampleCircle newCircle=new ExampleCircle();
 switch(event.getAction()){
   case MotionEvent.ACTION_DOWN :
    newCircle.setX((int)event.getX());
    newCircle.setY((int)event.getY()) ;
    newCircle.setColor(paint.setColor(Color.BLACK));
    break;

case MotionEvent.ACTION_UP:
    newCircle.setX((int)event.getX());
    newCircle.setY((int)event.getY()) ;
    newCircle.setColor(paint.setColor(Color.BLACK));
    break;
}

circleList.add(newCircle);
invalidate();
return true;