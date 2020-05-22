private static class Response {
    private final int responseCode;
    private final String url;

    Response(int responseCode, String url) {
        this.responseCode = responseCode;
        this.url = url;
    }

    // getters...

}

private static class XCell extends ListCell<Response> {
    private final HBox hB = new HBox();
    private final Label label = new Label("Empty");
    private final Button bB = new Button("Show Link");
    private final Text response = new Text();

    public XCell() {
        hB.getChildren().addAll(bB, response, label);
        bB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent eventTwo) {
                // handle button click using info from cell item
                Response item = getItem();
                WebElement linkTwo = driver.findElement(By.xpath("//a[contains(@href, '" + item.getUrl() + "')]"));
                scrolltoElement(linkTwo);
                HighlightThisLink(driver, linkTwo);
            }
        });
    }

    @Override
    protected void updateItem(Response item, boolean empty) {
        super.updateItem(item, empty);

        // update display
        if (empty || item == null) {
            setGraphic(null);
        } else {
            label.setText(item.getUrl());
            response.setText("("+Integer.toString(item.getResponseCode()) + "):");
            setGraphic(hB);
        }
    }
}