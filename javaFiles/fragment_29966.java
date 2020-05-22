public class PopulateComboBoxDemo extends Application {

    private ComboBox<String> people = new  ComboBox<>();
    private List<String> ids = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) { 
        this.populateData();

        BorderPane root = new BorderPane(); 
        root.setCenter(people);     
        Scene scene = new Scene(root, 300, 250);

        people.setOnAction(e -> {
            int index = people.getSelectionModel().getSelectedIndex();
            //here is the id_value
            String id_value = ids.get(index);
            System.out.println("The id of " + people.getItems().get(index) + " is : " + id_value);
            //
            //.........
            //
        });     
        primaryStage.setScene(scene);
        primaryStage.show();
    }   

    private void populateData() {
        this.people.getItems().clear();
        this.ids.clear();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/database","user","password");
            String sql = "select name, id from person";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            int index = 0;
            while(rs.next()) {
                this.people.getItems().add(index, rs.getString("name"));
                this.ids.add(index, String.valueOf(rs.getInt("id")));
                index++;
            }
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PopulateComboBoxDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    public static void main(String[] args) {
        launch(args);
    }   
}