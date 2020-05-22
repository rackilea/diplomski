public class PerformLogin implements IUserID {

private Connection con;
private PreparedStatement pst = null;
private ResultSet rs = null;

private static int userLoginID;

public PerformLogin(String un, String pw, StackPane basePane, Node rootPane) {

    try {
        this.con = bghsystems.database.DBHandler.connect();

        pst = con.prepareStatement("SELECT Emp_ID FROM User_Accnt where UA_UName = ? AND UA_Pass = ? COLLATE Latin1_General_CS_AS");
        pst.setString(1, un);
        pst.setString(2, pw);
        rs = pst.executeQuery();

        if (rs.next()) {
            PerformLogin.userLoginID = rs.getInt("Emp_ID");      // here is where I pass the data to the global variable

            try {
                Stage stage = (Stage) basePane.getScene().getWindow();
                stage.close();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/bghsystems/views/Dashboard.fxml"));
                Parent root = (Parent) loader.load();
                stage.setScene(new Scene(root));

                Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
                stage.setX(primaryScreenBounds.getMinX());
                stage.setY(primaryScreenBounds.getMinY());
                stage.setWidth(primaryScreenBounds.getWidth());
                stage.setHeight(primaryScreenBounds.getHeight());

                stage.show();

            } catch (IOException ex) {
                Logger.getLogger(PerformLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
        }

    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(PerformLogin.class.getName()).log(Level.SEVERE, null, ex);
    }

}

public PerformLogin() {

}

@Override
public int userID() {
    return PerformLogin.userLoginID;   //here is where I store the data
}