public void someLongTask(){
    new Thread(()->{
        //code for task here
        Platform.runLater(()->{
            //code to update UI here
        });
    }).start()
}