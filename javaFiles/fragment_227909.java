comboBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
    @Override
    public ListCell<String> call(ListView<String> p) {
        return new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setText(item);
                if (item == null || empty) {
                    setGraphic(null);
                } else {
                    Image icon;
                    try {
                        int iconNumber = this.getIndex() + 1;
                        String iconPath = "MyProject/resources/images/icon_" + iconNumber + ".png";
                        icon = new Image(getClass().getClassLoader().getResourceAsStream(iconPath));
                    } catch(NullPointerException ex) {
                        // in case the above image doesn't exist, use a default one
                        String iconPath = "MyProject/resources/images/icon_na.png";
                        icon = new Image(getClass().getClassLoader().getResourceAsStream(iconPath));
                    }
                    ImageView iconImageView = new ImageView(icon);
                    iconImageView.setFitHeight(30);
                    iconImageView.setPreserveRatio(true);
                    setGraphic(iconImageView);
                }
            }
        };
    }
});