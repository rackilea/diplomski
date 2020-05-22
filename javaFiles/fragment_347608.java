@Override
public void changed(ObservableValue<? extends Worker.State> observable, Worker.State oldValue, Worker.State newValue) {
    if (newValue==Worker.State.SUCCEEDED) {
        new Thread(() ->{
            try {
                while(true){
                    NodeList eval = eval(engine.getDocument(), "//span[@class='title']");
                    int s = eval.getLength();
                }
            } catch (XPathExpressionException ex) {
                Logger.getLogger(MVC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }
}