if(MAC) stage.setFullScreen(false);
stage.fullScreenProperty().addListener(new ChangeListener<Boolean>(){
        public void changed(ObservableValue<? extends Boolean> ov, Boolean oldv, Boolean newv){
            Platform.runLater(new Runnable(){
                public void run(){
                    if(MAC && oldv==false && newv==true)stage.setFullScreen(false);
                }
            });
        }
});