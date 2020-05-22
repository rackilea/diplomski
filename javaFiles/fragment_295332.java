public class Item extends Image {
    private String id;

    public Item(String id) {
        super(PicturesData.getPicture(getId());
        this.id = id;
        setPosition(50, 50);
        addListener(new DragListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                moveBy(x - getWidth()/2, y - getHeight()/2);
            }
        });
    }

    public String getId() {
        return id;
    }
}