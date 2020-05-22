public class MyJozanClass implements Updatable()
{
private float adjuster=0.00002f; ////you will have to adjust this depending on your ///times

float x=0;
float y=0;

public MyJozanClass()
{
}

public void onUpdate(long elapsedTimeNanos)
{

float newX=x+adjuster*elapsedTimeNanos;
float newY=y+adjuster*elapsedTimeNanos;

//////change positions

}

}