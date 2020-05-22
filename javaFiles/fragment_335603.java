webEngine.getLoadWorker().stateProperty().addListener(new ChangeListener<State>() {
     @Override
     public void changed(ObservableValue ov, State oldState, State newState) {

           if (newState == Worker.State.SUCCEEDED) {
                 System.out.println(webEngine.getLocation()); //NEW URL
           }

     }
});