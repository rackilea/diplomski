public class Player{

    private Animation  walkAnimation;
    private Texture    walkSheet;
    private TextureRegion[] walkFrames;
    private TextureRegion   currentFrame;
    private float stateTime;
    private Rectangle bound; //used for positioning and collision detection

    public Player(float x, float y, float width, float height){
        bound = new Rectangle(); 
        bound.x = x;
        bound.y = y;
        bound.width = width;
        bound.height = height;

        walkSheet = new Texture ("ninjaWalk.png");
        TextureRegion[][] tmp = TextureRegion.split(walkSheet,(int)walkSheetWidth/FRAME_COLS, (int) walkSheetHeight/FRAME_ROWS);
        walkFrames = new TextureRegion[FRAME_COLS*FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++){
            for (int j = 0; j < FRAME_COLS; j++) {
                walkFrames[index++] = tmp[i][j];
            }
        }
        walkAnimation = new Animation(0.0887f, walkFrames);
        stateTime = 0f;
    }

    public rectangle getBound(){
        return bound;
    }

    public void update(float delta){
        statetime += delta;
        currentFrame = walkAnimation.getKeyFrame(stateTime, true);
    }

    public TextureRegion getCurrentFrame(){
        return currentFrame;
    }

}