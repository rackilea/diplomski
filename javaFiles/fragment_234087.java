listView.setCellFactory(new Callback<ListView<String>, ListCell<String>>(){

        @Override
        public ListCell<String> call(ListView<String> p) {

            ListCell<String> cell = new ListCell<String>(){

                @Override
                protected void updateItem(String t, boolean bln) {
                    super.updateItem(t, bln);
                    if (t != null ) {
                        setText( t);

                        if (item_is_not_available){

                            if (!getStyleClass().contains("mystyleclass") {
                                getStyleClass().add("mystyleclass");
                            }

                        } else {
                            getStyleClass().remove("mystyleclass");
                        }
                    } else {
                        setText("");
                    }
                }

            };

            return cell;
        }
    });