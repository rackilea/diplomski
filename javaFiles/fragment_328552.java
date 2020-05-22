public class Background extends Entity {

    private Text text;

    public Background(float x, float y, float width, float height, Font font, String textMessage, VertexBufferObjectManager vertexBufferObjectManager) {
         this.setPosition(x, y);
         this.attachChild(new Rectangle(0, 0, width, height, vertexBufferObjectManager));
         this.text = new Text(0, 0, font, textMessage, vertexBufferObjectManager);
         this.attachChild(text);
    }

    @Override
    public void setAlpha(float pAlpha) {        
         super.setAlpha(pAlpha);
         this.text.setAlpha(pAlpha);
    }   
}