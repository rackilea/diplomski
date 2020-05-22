int [] object1Position = new int[2];  // declare int array for x,y object position
int [] object2Position = new int[2];  // the same

imageView1.getLocationOnScreen(object1Position); // get imageView1 position
imageView2.getLocationOnScreen(object2Position); // get imageView2 position

public boolean checkColisionOnXAxis()
{
    if (object1Position[0] == object2Position[0] )
       return true;
    return false;
}