public class CentipedeBody extends Sprite {

    enum State{
        LEFT,RIGHT,DOWN
    }

    State currentState,previousState ;

    public static final float DOWN_MOVEMENT=50;
    public float downMovCounter;
    public float speed;

    public CentipedeBody(TextureRegion image, Vector2 position, Vector2 size) {
        super(new TextureRegion(image));
        setPosition(position.x,position.y);
        setSize(size.x,size.y);
        currentState=State.LEFT;
        previousState=State.LEFT;
        speed=50;
    }

    public void update() {

        float delta=Gdx.graphics.getDeltaTime();
        if(currentState ==State.LEFT){
            setPosition(getX()-speed*delta,getY());
            if(getX()<0) {
                previousState=currentState;
                currentState = State.DOWN;
            }
        }

        if(currentState ==State.RIGHT){
            setPosition(getX()+speed*delta,getY());
            if(getX()> Gdx.graphics.getWidth()-getWidth()) {
                previousState=currentState;
                currentState = State.DOWN;
            }
        }

        if(currentState ==State.DOWN){
            setPosition(getX(),getY()+speed*delta);
            downMovCounter++;
            if(downMovCounter>DOWN_MOVEMENT){
                downMovCounter=0;
                currentState =previousState==State.LEFT?State.RIGHT:State.LEFT;
            }

        }
    }

}