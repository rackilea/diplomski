public class Parent {
    public static class Child {

        @FXML
        private Label label;

        @FXML
        private void initialize() {
            System.out.println("initialize " + getClass().getName());
            System.out.println("label =  " + label);
        }
    }
}