public class QuardTest extends ApplicationAdapter {

    Mesh quard;
    OrthographicCamera cam;
    ShaderProgram shaderProgram;

    private int Idx = 0;
    private float[] verts= new float[4 * 2];

    @Override
    public void create() {

        cam=new OrthographicCamera();
        shaderProgram=new ShaderProgram(Gdx.files.internal("default.vertex.glsl"),Gdx.files.internal("default.fragment.glsl"));
        if(shaderProgram.isCompiled()) {
            System.out.println("Compiled Successfully");
        }else {
            System.out.println("Some Problem in Shader");
        }

        quard =new Mesh(true,4,0,new VertexAttribute(VertexAttributes.Usage.Position, 2, "a_position"));
    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(1,1,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        drawRect(100,100,100,100);
        drawRect(250,250,50,50);
    }

    public void drawRect(float x, float y, float width, float height){

        if (Idx ==verts.length) {
            flush();
        }

        verts[Idx++] = x;
        verts[Idx++] = y;

        verts[Idx++] = x + width;
        verts[Idx++] = y;

        verts[Idx++] = x + width;
        verts[Idx++] = y + height;

        verts[Idx++] = x;
        verts[Idx++] = y + height;
    }

    public void flush(){

        if (Idx ==0)
            return;

        quard.setVertices(verts);
        Gdx.gl.glDepthMask(false);
        int vertexCount = (Idx /2);
        cam.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        shaderProgram.begin();
        shaderProgram.setUniformMatrix("u_projTrans", cam.combined);
        quard.render(shaderProgram, GL20.GL_TRIANGLE_FAN, 0, vertexCount);
        shaderProgram.end();
        Gdx.gl.glDepthMask(true);

        Idx =0;
    }
}