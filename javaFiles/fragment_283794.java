btn.setOnAction((ActionEvent event) -> {
        String c = "test"+(list.getItems().size()+1);
        list.getItems().add(list.getItems().size(), c);
        list.scrollTo(list.getItems().size() - 1);
        // list.edit(list.getItems().size() - 1);

        new AnimationTimer() {

            int frameCount = 0 ;

            @Override
            public void handle(long now) {
                frameCount++ ;
                if (frameCount > 1) {        
                    list.edit(list.getItems().size() - 1);
                    stop();
                }
            }

        }.start();
    });