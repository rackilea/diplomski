import java.awt.TextArea;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CusInfo
{
    //final Button button = new Button("Proceed");
    //final Label notification = new Label ();
    final TextField TF = new TextField("");
    final TextArea TA = new TextArea("");

    String address = " ";

    public Scene getScene()
    {
        Scene scene1 = new Scene(new Group(),450,250);

        final ListView LV = new ListView();
        LV.getItems().addAll(
        "ROSE",
        "TULIPS",
        "LILY",
        "CARNATION",
        "LAVENDER",
        "ORCHID",
        "SUNFLOWER",
        "LILAC",
        "HYACINTH",
        "DAISIES",
        "FORGET ME NOT",
        "PRIMROSE",
        "CAMELLIAS",
        "CHERRY BLOSSOM",
        "BIRD OF PARADISE"
        );

        final ComboBox CB1 = new ComboBox();
        CB1.getItems().addAll(
        "WHITE",
        "BLUE",
        "RED",
        "PURPLE",
        "BLACK",
        "YELLOW",
        "ORANGE"
        );

        final ComboBox CB2 = new ComboBox();
        CB2.getItems().addAll(
        "ENGLAND",
        "AMSTERDAM",
        "MALAYSIA",
        "ICELAND",
        "AUSTRALIA"
        );

        CB2.setValue("MALAYSIA");

        GridPane pane = new GridPane();
        pane.setVgap(4);
        pane.setHgap(10);
        pane.setPadding(new Insets(5,5,5,5));

           Label name = new Label ("Customer Name:");
           pane.add(name,0,0);
           TextField nameField = new TextField();
           pane.add(nameField,1 , 0);

           Label OrderID = new Label ("Order ID:");
           pane.add(OrderID, 0, 1);
           TextField OrderField = new TextField();
           pane.add(OrderField,1 ,1 );

           Label date = new Label ("Date:"); 
           pane.add(date,0,2);
           TextField dateField = new TextField();
           pane.add(dateField,1 , 2);

           Label phoneNum = new Label ("Phone Number:");
           pane.add(phoneNum,0,3);
           TextField phoneField = new TextField();
           pane.add(phoneField,1 , 3);

           pane.add (new Label ("Type of Flower:"),0,4);
           pane.add(LV,1,4);
           //TextField flowerField = new TextField();
           //pane.add(flowerField,1 , 4);

           pane.add( new Label ("Flower Colour:"),0,5);
           pane.add(CB1,1,5);
           //TextField colourField = new TextField();
           //pane.add(colourField,1 , 5);

           pane.add( new Label ("Origin:"),0,6);
           pane.add(CB2,1,6);
           //TextField originField = new TextField();
           //pane.add(colourField,1 , 6);

           Label quantity = new Label ("Quantity:");
           pane.add(quantity,0,7);
           TextField quantityField = new TextField();
           pane.add(quantityField,1 , 7);

           Label totalPrice = new Label ("Total Price:");
           pane.add(totalPrice,0,8); 
           TextField priceField = new TextField();
           pane.add(priceField,1,8);

           Label address = new Label ("Customer Address:");
           pane.add(address,0,9);
           TextField addressField = new TextField();
           pane.add(addressField,1 , 9);

           Button button = new Button("Proceed");
           pane.add(button, 1, 10);

           Group root = (Group)scene1.getRoot();
           root.getChildren().add(pane);

           return scene1;
        }
    }