public class ShaderTest extends ApplicationAdapter {

    SpriteBatch spriteBatch;
    Texture texture;
    ShaderProgram shaderProgram;

    @Override
    public void create() {
        spriteBatch=new SpriteBatch();

         shaderProgram=new ShaderProgram(Gdx.files.internal("default.vertex.glsl"),Gdx.files.internal("default.fragment.glsl"));
         shaderProgram.pedantic = false;
         if(shaderProgram.isCompiled()) {
            System.out.println("Compiled Successfully");
            spriteBatch.setShader(shaderProgram);
         }else {
            System.out.println("Some Problem in Shader");
         }

        texture=new Texture("badlogic.jpg");
    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(1,1,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.begin();
        spriteBatch.draw(texture,100,100);
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        shaderProgram.dispose();
        texture.dispose();
        spriteBatch.dispose();
    }
}