public class RemovingCell extends TableCell<Client, Client> {
private HoverButton hb = new HoverButton(Color.RED);

public RemovingCell(ObservableList<Client> data) {
    super();
    setAlignment(Pos.CENTER);
    try {
        ImageView imgv = new ImageView(new Image(new FileInputStream(
                "img/Remove.png")));
        imgv.setFitWidth(15);
        imgv.setPreserveRatio(true);
        imgv.setSmooth(true);
        hb.setGraphic(imgv);
        hb.setTooltip(ControlFactory.getTooltip("Klient entfernen"));
        hb.setOnAction(event -> {
            data.remove(getTableRow().getIndex());
        });

        // conditionally set the graphic:
        // setGraphic(hb);

        emptyProperty().addListener( (obs, wasEmpty, isNowEmpty) -> {
            if (isNowEmpty) {
                setGraphic(null);
            } else {
                setGraphic(hb);
            }
        });

        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
    }
}