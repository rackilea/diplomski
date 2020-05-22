import java.awt.Rectangle;

public class DropObject {

    private int         yukseklik;  // height
    private Rectangle   object;

    public DropObject(int yukseklik, int x, int y, int size) {
        this.yukseklik = yukseklik;
        this.object = new Rectangle(x, y, size, size);
    }

    public int getYukseklik() {
        return yukseklik;
    }

    public void setYukseklik(int yukseklik) {
        this.yukseklik = yukseklik;
    }

    public Rectangle getObject() {
        return object;
    }

    public void setObject(Rectangle object) {
        this.object = object;
    }

}