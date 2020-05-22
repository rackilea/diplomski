public class MainController {

    @FXML
    private Label myMessage;

    @FXML
    void generaterandom (ActionEvent event){
        Random rand=new Random();
        int myrand=rand.nextInt(50)+1;
        myMessage.setText(Integer.toString(myrand));
        System.out.println(Integer.toString(myrand));


    }

}