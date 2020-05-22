public class FXMLController { 
@FXML TextField input 
@FXML private Text actionContains 
@FXML protected void handleSubmitButtonAction(ActionEvent event) { 
List<String> n1 = Arrays.asList("44606", "44613", "44615", "44619"}
String getInput = input.getText();

for(String s : n1) { 
  if(getinput.contains(s)) { 
      actionContains.setText("CONTAINS"); 
   } else { 
       actionContains.setText("DOES NOT CONTAIN"); 
   } 
} 
}