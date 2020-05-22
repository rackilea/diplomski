class MyActor extends Actor
{
    ...

    public boolean amIBeingDragged = false;

    public void act(float delta)
    {
        super.act(delta);

        if( amIBeingDragged )
        {
            Vector2 position = new Vector2(this.getX(), this.getY());

            for(Actor actor : this.getStage().getActors())
            {
                 if(actor == this) continue;

                 if(position.dst( new Vector2( actor.getX(), actor.getY() < thresholdDistance )
                 {
                     this.setPosition( actor.getX(), actor.getY() );
                 }
            }
        }
    }
}

//drag's listener methods
public void dragStart(InputEvent event, float x, float y, int pointer)
{ 
    ( (MyActor) event.getTarget() ).amIBeingDragged = true;
}

public void dragStop(InputEvent event, float x, float y, int pointer)
{ 
    ( (MyActor) event.getTarget() ).amIBeingDragged = false;
}

...