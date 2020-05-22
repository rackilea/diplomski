import java.net.URL;
import java.time.LocalDate;
import java.time.chrono.HijrahChronology;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import javafx.util.StringConverter;

/**
 *
 * @author Fouad
 */
public class FXMLDocumentController implements Initializable
{
    @FXML
    private DatePicker dpDate;

    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        dpDate.setValue(LocalDate.now());
        dpDate.setChronology(HijrahChronology.INSTANCE);

        Callback<DatePicker, DateCell> dayCellFactory = dp -> new DateCell()
        {
            @Override
            public void updateItem(LocalDate item, boolean empty)
            {
                super.updateItem(item, empty);

                if(item.isBefore(LocalDate.now()) || item.isAfter(LocalDate.now().plusYears(1)))
                {
                    setStyle("-fx-background-color: #ffc0cb;");
                    Platform.runLater(() -> setDisable(true));

                    /* When Hijri Dates are shown, setDisable() doesn't work. Here is a workaround */
                    //addEventFilter(MouseEvent.MOUSE_CLICKED, e -> e.consume());
                }
            }
        };

        StringConverter<LocalDate> converter = new StringConverter<LocalDate>()
        {
            final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            @Override
            public String toString(LocalDate date)
            {
                if(date != null) return dateFormatter.format(date);
                else return "";
            }

            @Override
            public LocalDate fromString(String string)
            {
                if(string != null && !string.isEmpty())
                {
                    LocalDate date = LocalDate.parse(string, dateFormatter);

                    if(date.isBefore(LocalDate.now()) || date.isAfter(LocalDate.now().plusYears(1)))
                    {
                        return dpDate.getValue();
                    }
                    else return date;
                }
                else return null;
            }
        };

        dpDate.setDayCellFactory(dayCellFactory);
        dpDate.setConverter(converter);
        dpDate.setPromptText("dd/MM/yyyy");
    }

}