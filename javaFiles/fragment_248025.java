import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ChangeImageInShape extends Application {

    private int imageSelected = 0;
    private Sprite player;

    private static final String[] fishImages = {
            "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/160/lg/57/tropical-fish_1f420.png",
            "https://www.shareicon.net/data/128x128/2015/03/28/14104_animal_256x256.png",
            "https://cdn1.iconfinder.com/data/icons/DarkGlass_Reworked/128x128/apps/gnome-fish.png",
            "http://www.iconsalot.com/asset/icons/freepik/pet-shop-13/128/010-fish-2-icon.png"
    };
    private final Image[] images = new Image[fishImages.length];

    @Override
    public void start(Stage stage) throws Exception {

        for(int i = 0 ; i < images.length ; i++){
            images[i] = new Image(fishImages[i]); //loading images takes some time 
        }

        player = new Sprite (0,0,80,80, "player",Color.BLUE);
        changeImageInSprite();

        Button btn = new Button("Change Image In Sprite");
        btn.setOnAction(e->changeImageInSprite());

        Pane root = new BorderPane(player, null, null, btn, null);
        root.setPrefSize(300,200);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void changeImageInSprite() {
        player.setFill(new ImagePattern(images[imageSelected++]));
        imageSelected = imageSelected >= images.length ?  0 : imageSelected;
    }

    private static class Sprite extends Rectangle {

        Sprite(int x, int y, int w, int h, String type, Color colour){
            super(w, h, colour);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}