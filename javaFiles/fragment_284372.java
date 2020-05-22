private void showselectedlist(){
    orderitems.addAll(ChosenItemsStat.chosenorderitemsstat);
    ChosenItemsStat.chosenorderitemsstat.clear();
    ListView<OrderItem> selectedlist = new ListView<>();
    ObservableList<OrderItem> myObservableList = FXCollections.observableList(orderitems);
    selectedlist.setItems(myObservableList);
    selectedlist.setMaxWidth(220);
    selectedlist.setCellFactory(new Callback<ListView<OrderItem>, ListCell<OrderItem>>() {

        @Override
        public ListCell<OrderItem> call(ListView<OrderItem> p) {
            ListCell<OrderItem> cell = new ListCell<OrderItem>(){
                OrderedCell ordcell= new OrderedCell();
                @Override
                protected void updateItem(OrderItem orderitem, boolean bln) {
                    super.updateItem(orderitem, bln);
                    if (orderitem != null) {
                        Float price = ordcell.getitemTempPrice(orderitem,orderitem.read_item_price);

                        HBox namepriceHbox = new HBox();
                        Label lblprice= new Label(String.format("%.2f",price));
                        Region betweenregion = new Region();
                        Label lblname = new Label();

                        lblname.setText(orderitem.read_item_name );
                        lblname.setStyle("-fx-font: 10pt  \"Arial\";-fx-font-weight:bold");

                        namepriceHbox.setHgrow(betweenregion, Priority.ALWAYS);
                        namepriceHbox.getChildren().addAll(lblname,betweenregion,lblprice);

                        VBox allVbox = new VBox();
                        Text lblchoices = new Text();

                        String choices = ordcell.choicestostring(orderitem);
                        lblchoices.setText(choices);
                        lblchoices.setWrappingWidth(listpane.getLayoutBounds().getWidth());

                        if (choices.equals("")) allVbox.getChildren().addAll(namepriceHbox);
                        else allVbox.getChildren().addAll(namepriceHbox, lblchoices);

                        double namepricewidth = listpane.getLayoutBounds().getWidth();
                        System.out.println("namepricewidth is "+String.valueOf(namepricewidth));

                        //allVbox.setPadding(new Insets(10,0,10,0));
                        setGraphic(allVbox);
                    }
                }

            };
            return cell;
        }
    });
    listpane.getChildren().add(selectedlist);
}