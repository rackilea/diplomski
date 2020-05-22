public class ResultScreen extends AbstractScreen{

    private OrthographicCamera camera;
    private Viewport viewport;
    private BitmapFont font;
    private Batch batch; //<------------changed
    private String res;
    private float time = 10;
    private Texture tfBackground, knob_scroll, scroll_horizontal;
    private List<String> scoreList;
    private ScrollPane scrollPane;
    private List.ListStyle listS;
    private ScrollPane.ScrollPaneStyle sps;
    private Array<String> items;

    public ResultScreen(float time, String res) {
        super(new StretchViewport(800, 1024)); //Call an AbstractScreen constructor that calls a Stage constructor
        this.time = time;
        font = new BitmapFont(Gdx.files.internal("aw.fnt"));
        font.setColor(Color.BLACK);
        camera = getCamera(); //<------------changed
        viewport = getViewport(); //<------------changed
        batch = getBatch(); //<------------changed
        camera.position.x = 400;
        camera.position.y = 512;
        // unnecessary can remove because this is called in resize: viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        this.res = res;
        fillList();
    }
}