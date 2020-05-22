@Override
    public void start(Stage primaryStage) {
        FXMLLoader loader = new FXMLLoader(); 
        loader.setLocation(getClass().getResource("Calculator.fxml")); 
        Parent root;
        try {
            root = loader.load();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("Calculator.css").toExternalForm());

            CalculatorController controller = loader.<CalculatorController>getController(); //Gain a reference to the Controller
            ICalculator myFibonnaciCalculator = new FibonnaciCalculator(); // FibonnaciCalculator implements ICalculator
            controller.setCalculator(myFibonnaciCalculator); // set the type of calculator you want to use.

            primaryStage.setScene(scene);
            primaryStage.show();
        } 
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }