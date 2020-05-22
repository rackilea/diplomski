public class LauncherScreen implements Screen{

//-----------------------------------------------------------
//-----------------idle Animation----------------------------
//-----------------------------------------------------------

Texture texture;

AnimatedSprite animationForMultiplayer;
SpriteBatch spriteBatch;   
Player mySelf;

OrthographicCamera playerCam;
OrthographicCamera mpPlayerCam;
OrthographicCamera camera;

ShapeRenderer shapeRenderer;

static Client client = new Client();
Launcher launcher = new Launcher();


int[][] map = {{1,1,1,1,1,1,1,1,1,1},
               {1,0,0,0,0,0,0,0,0,1},
               {1,0,0,0,0,0,0,0,0,1},
               {1,0,0,0,0,0,0,0,0,1},
               {1,0,0,0,0,0,0,0,0,1},
               {1,0,0,0,0,0,0,0,0,1},
               {1,0,0,0,0,0,0,0,0,1},
               {1,0,0,0,0,0,0,0,0,1},
               {1,0,0,0,0,0,0,0,0,1},
               {1,1,1,1,1,1,1,1,1,1}};


@Override
public void render(float delta) {
    // TODO Auto-generated method stub

    Gdx.gl.glClearColor(1, 1, 1, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


    launcher.update();


    for(int i = 0; i < map.length; i++){


        for(int j = 0; j < map[0].length; j++){

            if(map[i][j] == 1){

                 shapeRenderer.setProjectionMatrix(camera.combined);

                 shapeRenderer.begin(ShapeType.Line);
                 shapeRenderer.setColor(0, 0, 0, 0);
                 shapeRenderer.rect(i*50, j*50, 50, 50);
                 shapeRenderer.end();

            }

        }

    }



    for(MPPlayer mpPlayer : launcher.getPlayersValue()){   

        //System.out.println("mpPlayerXandY : "+mpPlayer.state);

        animationForMultiplayer.setState(mpPlayer.state);

        animationForMultiplayer.createAnimation();

        //mpPlayerCam.update();

        //spriteBatch.setProjectionMatrix(mpPlayerCam.combined);        

        camera.position.set(mpPlayer.x,mpPlayer.y,0);


        spriteBatch.setProjectionMatrix(camera.combined);

        spriteBatch.begin();                
        spriteBatch.draw(animationForMultiplayer.convertAnimationTOframes(), mpPlayer.x, mpPlayer.y,Gdx.graphics.getWidth()/25,Gdx.graphics.getHeight()/15);     // #6
        spriteBatch.end();

        //mpPlayerCam.position.set(mpPlayer.x,mpPlayer.y,0);


        System.out.println("mpPlayer : "+mpPlayer.x+" "+mpPlayer.y);


    }


    mySelf.update();
    mySelf.draw(launcher.getPlayerX(), launcher.getPlayerY(), camera);

    //System.out.println(Gdx.graphics.getFramesPerSecond());

    camera.update();

    System.out.println("player : "+launcher.getPlayerX()+" "+launcher.getPlayerY());


}

@Override
public void pause() {
    // TODO Auto-generated method stub

    //super.pause();

}

@Override
public void resume() {
    // TODO Auto-generated method stub

    //super.resume();

}

@Override
public void dispose() {
    // TODO Auto-generated method stub

    //super.dispose();

}


@Override
public void show() {
    // TODO Auto-generated method stub

    texture = new Texture(Gdx.files.internal("EnemyAnimations/BugIdleStand.png"));
    animationForMultiplayer = new AnimatedSprite();
    spriteBatch = new SpriteBatch();              
    mySelf = new Player();

    mySelf.doSetup();



    playerCam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    playerCam.setToOrtho(false);
    playerCam.position.set(mySelf.getX(), mySelf.getY(), 0);

    mpPlayerCam = new OrthographicCamera(0,0);
    mpPlayerCam.setToOrtho(false);


    camera = new OrthographicCamera(0, 0);
    camera.setToOrtho(false);



    shapeRenderer = new ShapeRenderer();

}


@Override
public void resize(int width, int height) {
    // TODO Auto-generated method stub

}


@Override
public void hide() {
    // TODO Auto-generated method stub

}






 }