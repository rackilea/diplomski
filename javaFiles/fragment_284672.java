import java.util.ArrayList;


public class Image {

    public static ArrayList<Image> list = new ArrayList<>();

    public void addLib() {
        list.add(this);
    }

    public static void main(String[] args) {
        new Image().addLib();
        new Image().addLib();
        new Image().addLib();

        for (Image image : list) {
            System.out.println("Image "+image+" is in store");
        }
    }

}