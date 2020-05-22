public class TodoListController implements Initializable {

    @FXML
    public TextField input;

    @Override
    public void initialize(final URL url, final ResourceBundle resourceBundle) {
        input.setTextFormatter(new TextFormatter<>(new NumberFormatUnaryOperator()));
    }

    private static final class NumberFormatUnaryOperator implements UnaryOperator<TextFormatter.Change> {

       /**
        * Applies this function to the given argument.
        *
        * @param change the function argument
        * @return the function result
        */
        @Override
        public TextFormatter.Change apply(TextFormatter.Change change) {
           String text = change.getControlNewText();

           if (!text.matches("\\d*")) {
               Toolkit.getDefaultToolkit().beep();
               return null;
           }

           return change;
        }
    }
}