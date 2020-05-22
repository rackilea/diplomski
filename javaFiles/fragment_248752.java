public class Calculator extends Application {

    private GridPane root ;

    @Override
    public void start(Stage primaryStage) {
        root = new GridPane()

        // zero button:
        root.add(1, 4, createNumericalButton(0));

        // buttons for 1-9:
        for (int i = 1 ; i <= 9 ; i++) {
            Button button = createNumericalButton(i);
            int row = 2 - (i-1)/3 ; // {7,8,9} -> 0; {4,5,6} -> 1; {1,2,3}->2
            int col = (i-1) % 3 ;
            root.add(col, row, button);
        }

        // other layout...

    }

    private Button createNumericalButton(final int n) {
        Button button = new Button(Integer.toString(n));
        button.setMinSize(32, 32);
        button.setOnAction(event -> {
            // replace with real handler...
            System.out.println("Pressed "+n);
        }
        return button ;
    }
}