public class ContentTab extends VBox{
    Label allegati;
    TextField inseriscitesto;
    ListView<MyObject> view;

    public ContentTab(int width){

         setPadding(new Insets(20));
         setSpacing(10);
         allegati = new Label("Allegati alla lezione");
         allegati.setFont(Font.font("Verdana", 13));
          inseriscitesto = new TextField("");
         FilteredList<MyObject> filteredData = new FilteredList(FXCollections.observableArrayList(), s -> true);

         view = new ListView<MyObject>(filteredDate);
        inseriscitesto.textProperty().addListener(obs->{
            String filter = inseriscitesto.getText(); 
            if(filter == null || filter.length() == 0) {
                filteredData.setPredicate(s -> true);
            }
            else {
                filteredData.setPredicate(s -> s.getTitolo().contains(filter));
            }
        });

         view.setStyle("-fx-background-color: transparent;");
        setPrefWidth(width);
        getChildren().addAll(allegati,inseriscitesto, view);

    }