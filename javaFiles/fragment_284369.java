public class NamePriceCell extends ListCell<ReadItemChoiceObj> {
@FXML
Label namelbl;

@FXML
Label pricelbl;

@FXML
Button plusbtn;

@FXML
Region spacer;

@FXML
HBox cellHbox;

FXMLLoader mLLoader;

ReadItemChoiceObj readitem;

@Override
protected void updateItem(ReadItemChoiceObj readitem, boolean empty) {
    super.updateItem(readitem, empty);

    if(empty || readitem == null) {

        setText(null);
        setGraphic(null);

    } else {

        this.readitem = readitem;
        if (mLLoader == null) {
            mLLoader = new FXMLLoader(getClass().getResource("fxml/NamePriceCell.fxml"));
            mLLoader.setController(this);
            try {
                mLLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        namelbl.setText(readitem.getname());
        namelbl.setMaxWidth(500);
        pricelbl.setText(String.format("%.2f", readitem.getprice()));
        pricelbl.setStyle("-fx-font: 8pt  \"Arial\";");
        pricelbl.setMaxWidth(40);
        spacer.setMaxWidth(10);
        spacer.setMinWidth(10);
        plusbtn.setMaxWidth(20);
        cellHbox.setHgrow(namelbl, Priority.ALWAYS);

        cellHbox.setAlignment(Pos.BASELINE_LEFT);

        setText(null);
        setGraphic(cellHbox);

        plusbtn.setOnMouseClicked(whattodohandler);
    }

}



EventHandler<MouseEvent> whattodohandler = new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent event) {


        OrderItem orderitem = new OrderItem();
        orderitem.read_item_name = readitem.getname();
        orderitem.read_item_price=readitem.getprice();
        orderitem.read_itemID=readitem.getid();
        orderitem.choice_name_list = new ArrayList<String>();
        orderitem.choice_price_list = new ArrayList<Float>();
        orderitem.choice_id_list = new ArrayList<Integer>();

        ChosenItemsStat.getplusbtnclicked(orderitem);
        Random rand = new Random();
        TablesMain.stringProperty.setValue(String.valueOf(rand));
    }
};

}