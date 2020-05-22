primaryStage.initStyle(StageStyle.UTILITY); // prevent system from adding window to cycle
    primaryStage.iconifiedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {
                primaryStage.setIconified(false); //if window was minimized by user example: user pressed "super+d" window is still visible like widget 
            }
        });