public class LoginPage extends View {
     private Parent root;

     private LoginPage(BorderPane root) {
         super(root);
         Scene scene = new Scene(root, 500, 800);
         VBox login = new VBox();
         ...
         root.setBottom(newAccount);
         setCenter(login);
         ...
         VBox newAccount = new VBox();
         ...
         root.setBottom(newAccount);
    }

    public LoginPage() {
        this(new BorderPane());
    }
}