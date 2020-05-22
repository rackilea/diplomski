public class MyTest extends ApplicationTest {

@Override
public void start (Stage stage) throws Exception {
    FXMLLoader loader = new FXMLLoader(
            getClass().getResource("mypage.fxml"));
    stage.setScene(scene = new Scene(loader.load(), 300, 300));
    stage.show();
}