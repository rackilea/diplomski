public class SpriteSheetAnimation extends GameObjectTemplate {

    int animationSheetLength;
    int animationSheetHeight;
    int columns;
    int rows;
    Rect srcRect;

    int left;
    int bottom;
    int lengthOfSpriteInSheet;
    int heightOfSpriteInSheet;

    boolean repeatAnimation;
    boolean animationCompleted;
    boolean animationStarted;

    Bitmap bitmap;

    /**
     * You input a bitmap and the number of sprites (by defining the number of rows and columns), and this class will
     * take care of animating the sheet. 
     * 
     */

    public SpriteSheetAnimation(WorldTemplate world, Bitmap animationSheet, int amountOfRows, int amountOfColumns) {
        super(world);
        this.animationSheetLength = animationSheet.getWidth();
        this.animationSheetHeight = animationSheet.getHeight();
        this.columns = amountOfColumns;
        this.rows = amountOfRows;
        this.lengthOfSpriteInSheet = this.animationSheetLength/this.columns;
        this.heightOfSpriteInSheet = this.animationSheetHeight/this.rows;
        srcRect = new Rect();

        left = 0;
        bottom = this.heightOfSpriteInSheet;

        repeatAnimation = false;
        animationCompleted = false;
        animationStarted = false;

        this.bitmap = animationSheet;
        this.drawShapesOfSprites = true;

        this.gameObjectShape.addRectangle(new Rect(0, 0, 0 + this.heightOfSpriteInSheet, 0 + this.lengthOfSpriteInSheet));

    }

    @Override
    public void defineGameObjectPositionShape() {
        this.gameObjectShape.addRectangle(new Rect());

    }

    /**
     * <b><i>public Rect getSrcRect()</i></b>
     * <br>
     * Since: API 1
     * <br>
     * <br>
     * Retrieve the rect that will cover the current source of the sheet.
     * 
     * @return 
     * The current rect that will cover the current source of the sheet.
     *
     */

    public Rect getSrcRect() {
        return srcRect;
    }

    /**
     * <b><i>public Rect getDstRect()</i></b>
     * <br>
     * Since: API 1
     * <br>
     * <br>
     * Retrieve the rect where the bitmap will be scaled to fit into.
     * 
     * @return 
     * The current rect where the bitmap will be scaled to fit into.
     *
     */

    public Rect getDstRect() {
        return this.getGameObjectPositionRect();
    }

    /**
     * <b><i>public void repeatAnimation(boolean repetition)</i></b>
     * <br>
     * Since: API 1
     * <br>
     * <br>
     * This method will set if the animation should be repeated or not.
     * 
     * @param state 
     * <br><br>
     * 1. True = The animation will repeat once completed and keep on doing so.
     * <br><br>
     * 2. False = The animation will play only once.
     *
     *      
     */

    public void repeatAnimation(boolean repetition) {
        this.repeatAnimation = repetition;
    }

    /**
     * <b><i>public boolean isAnimationFinished()</i></b>
     * <br>
     * Since: API 1
     * <br>
     * <br>
     * Retrieve if the animation has finished.
     * 
     * @return 
     * If the animation has finished.
     *
     */

    public boolean isAnimationFinished() {
        return animationCompleted;
    }

    /**
     * <b><i>public boolean hasBeenStarted()</i></b>
     * <br>
     * Since: API 1
     * <br>
     * <br>
     * Retrieve if the animation has started.
     * 
     * @return 
     * If the animation has started.
     *
     */

    public boolean hasBeenStarted() {
        return animationStarted;
    }

    /**
     * <b><i>public void render()</i></b>
     * <br>
     * Since: API 1
     * <br>
     * <br>
     * This method will render the animation (the current picture of the sheet).
     *
     */

    public void render() {
        world.game.getGraphics().getCanvasGameScreen().drawBitmap(this.bitmap, this.getSrcRect(), this.getGameObjectPositionRect(), null);
    }

    /**
     * <b><i>public void update()</i></b>
     * <br>
     * Since: API 1
     * <br>
     * <br>
     * This method will update the animation.
     *
     */

    @Override
    public void update() {
        // Every update will advance to the next frame of the animation
        // Set if animation has started
        if(!animationStarted) {
            animationStarted = true;
        }

        // Set the frame
        srcRect.set(left, (bottom - this.heightOfSpriteInSheet), (left + this.lengthOfSpriteInSheet), bottom);
        // Change the location, so the next time the frame is set, it will be set accordingly
        left = left + this.lengthOfSpriteInSheet;

        if(left == this.animationSheetLength && bottom == this.animationSheetHeight) {
            if(repeatAnimation == true) {
                left = 0;
                bottom = 0;
            }
            else {
                animationCompleted = true;
            }
        }

        if(left == this.animationSheetLength) {
            bottom = bottom + this.heightOfSpriteInSheet;
            left = 0;
        }

    }


}