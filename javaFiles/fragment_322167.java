import java.awt.Image;

public class CellView {
    //public CellViewHelper helper; // CellViewHelper is just an example

    public CellView() {
        //this.helper = new CellViewHelper();
        //this.helper.someVariable = <anything>;

        System.out.println("CellView_constructor");
    }

    public void draw() {
        System.out.println("CellView_draw");
    }

    public static void main(String[] args) {
        ImageCellView imageCellView = new ImageCellView();
        imageCellView.draw();
    }
}

class ImageCellView extends CellView {

    public Image someImage;

    public ImageCellView() {
        super();
        //this.someImage = new Image();
        System.out.println("ImageCellView_constructor");
    }

    @Override public void draw() {
        super.draw();
        System.out.println("ImageCellView_draw");
    }

}