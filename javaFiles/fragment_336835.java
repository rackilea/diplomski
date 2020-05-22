import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

/**
 *
 * @author blj0011
 */
public class FXMLDocumentController implements Initializable
{

    @FXML
    private Label label;
    @FXML
    private Accordion accordionMain;

    List<TextField> textFieldContainer = new ArrayList();

    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        //Sum TextField
        double total = 0;

        for (TextField node : textFieldContainer) {
            double value;
            try {
                value = Double.parseDouble(node.getText());
            }
            catch (NumberFormatException e) {
                value = 0;
            }

            total += value;

        }
        label.setText("Sum: " + total);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
        accordionMain.getPanes().add(createTitledPanePlant(1));
        accordionMain.getPanes().add(createTitledPanePlant(2));

    }

    protected TitledPane createTitledPanePlant(int index)
    {
        TilePane tile = new TilePane(Orientation.HORIZONTAL, 5, 5);
        Label typeLabel = new Label("Тип выпуска");
        TextField typeText = new TextField();
        textFieldContainer.add(typeText);//Add your textField to the container when you create it
        VBox typeContainer = new VBox(typeLabel, typeText);

        Label bankLabel = new Label("Берег");
        Tooltip.install(bankLabel, new Tooltip("Берег, с которого производится выпуск"));
        TextField bankText = new TextField();
        textFieldContainer.add(bankText);//Add your textField to the container when you create it
        VBox bankContainer = new VBox(bankLabel, bankText);

        tile.getChildren().addAll(typeContainer, bankContainer);

        TitledPane titledPane = new TitledPane("Параметры выпуска " + index, tile);

        return titledPane;
    }
}