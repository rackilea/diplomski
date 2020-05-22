package mcve.javafx;

import java.util.List;
import java.util.stream.Collectors;

import org.fxmisc.easybind.EasyBind;
import org.fxmisc.easybind.monadic.MonadicBinding;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private CheckBox checkShowMore;

    @Override
    public void start(Stage primaryStage) {
        try {


            // Initialize model
            MasterDetailModel mdModel = new MasterDetailModel();
            ObservableList<ModelItem> itemsList = FXCollections.observableArrayList();
            for (int i=0;i<5;i++) { itemsList.add(newModelItem(i)); }

            MonadicBinding<ModelItem> selectedItemBinding = EasyBind.monadic(mdModel.selectedItemProperty()).orElse(new ModelItem());

            // Master
            ListView<ModelItem> listView = new ListView<ModelItem>();
            listView.setItems(itemsList);
            listView.setPrefHeight(150);
            mdModel.selectedItemProperty().bind(listView.getSelectionModel().selectedItemProperty());

            //Detail
            checkShowMore = new CheckBox();
            checkShowMore.setText("Show more details");
            VBox detailVBox = new VBox();           
            Label apiLabel = new Label();
            Label labelPlayground = new Label();
            detailVBox.getChildren().addAll(
                    checkShowMore, 
                    new TitledPane("API Binding", apiLabel), 
                    new TitledPane("EasyBind", labelPlayground)
            );


            // Scene
            Scene scene = new Scene(new VBox(listView, detailVBox),400,400);
            primaryStage.setScene(scene);
            primaryStage.setTitle("JavaFX/EasyBind MVCE");

            // --------------------------
            // -------- BINDINGS --------
            // --------------------------

            // API Label Binding

            apiLabel.textProperty().bind(Bindings.createStringBinding( 
                () -> selectedItemBinding.getValue().getDetails().stream()
                    .map(i -> derivedBinding(i.aProperty(), i.bProperty()))
                    .map(v->v.getValue())
                    .collect(Collectors.joining(", "))
                , mdModel.selectedItemProperty(), checkShowMore.selectedProperty()));

            // EasyBind non-working attempt
            /*
            ListProperty<ModelItemDetail> obsList = new SimpleListProperty<>(FXCollections.observableArrayList(i->new Observable[] { i.aProperty(), i.bProperty(), checkShowMore.selectedProperty()}));
            obsList.bind(selectedItemBinding.flatMap(ModelItem::detailsProperty));
            ObservableList<ModelItemDetail> ebDetailList = obsList; // WHY ??
            ObservableList<ObservableValue<String>> ebDerivedList = EasyBind.map(ebDetailList, i -> derivedBinding(i.aProperty(), i.bProperty()));
            ObservableValue<String> ebDerivedValueBinding = EasyBind.combine(ebDerivedList, stream -> stream.collect(Collectors.joining(", "))).orElse("Nothing to see here, move on");
            labelPlayground.textProperty().bind(ebDerivedValueBinding);
            */

            // Working EasyBind Binding
            labelPlayground.textProperty().bind(
                    selectedItemBinding
                    .flatMap(ModelItem::detailsProperty)
                    .map(l -> derivedBinding(l))
                    .flatMap(l -> EasyBind.combine(l, stream -> stream.collect(Collectors.joining(", "))))
                    );

            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private ObservableList<ObservableValue<String>> derivedBinding(ObservableList<ModelItemDetail> l) { 
        return l.stream()
                .map(c -> derivedBinding(c.aProperty(), c.bProperty()))
                .collect(Collectors.toCollection(FXCollections::observableArrayList));
    }

    private Binding<String> derivedBinding(ObservableValue<String> someA, ObservableValue<String> someB ) { 
        return EasyBind.combine(someA, someB, checkShowMore.selectedProperty(), 
                        (a, e, s) -> a + (Boolean.TRUE.equals(s) ? " <" + e + ">" : ""));
    }

    private ModelItem newModelItem(int number) { 
        ModelItem item = new ModelItem();
        item.itemNumber = number+1;
        for (int i=0;i<2;i++) { 
            ModelItemDetail detail = new ModelItemDetail("A" + (i+item.itemNumber), "B" + (i+item.itemNumber));
            item.getDetails().add(detail);
        }
        return item;
    }

    /** GUI Model class */ 
    private static class MasterDetailModel {
        private ObjectProperty<ModelItem> selectedItemProperty = new SimpleObjectProperty<>();
        public ObjectProperty<ModelItem> selectedItemProperty() { return selectedItemProperty; }
        public ModelItem getSelectedItem() { return selectedItemProperty.getValue(); }
        public void setSelectedItem(ModelItem item) { selectedItemProperty.setValue(item); }
    }

    /** Domain Model class */
    private static class ModelItem { 
        int itemNumber;
        private ListProperty<ModelItemDetail> detailsProperty = new SimpleListProperty<>(FXCollections.observableArrayList());
        public ListProperty<ModelItemDetail> detailsProperty() { return detailsProperty; }
        public ObservableList<ModelItemDetail> getDetails() { return detailsProperty.getValue(); }
        public void setDetails(List<ModelItemDetail> details) { detailsProperty.setValue(FXCollections.observableList(details)); }
        public String toString() { return "Item " + itemNumber; }
    }

    /** Domain Model class */
    private static class ModelItemDetail {

        public ModelItemDetail(String a, String b) { 
            setA(a);
            setB(b);
        }

        private StringProperty aProperty = new SimpleStringProperty();
        public StringProperty aProperty() { return aProperty; }
        public String getA() { return aProperty.get(); }
        public void setA(String a) { aProperty.set(a); }

        private StringProperty bProperty = new SimpleStringProperty();
        public StringProperty bProperty() { return bProperty; }
        public String getB() { return bProperty.get(); }
        public void setB(String b) { bProperty.set(b); }
    }
}