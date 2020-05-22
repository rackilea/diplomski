@FXML
void loadPressed(ActionEvent event) throws FileNotFoundException, IOException{

 FileChooser myfileChooser = new FileChooser();
 myfileChooser.setTitle("Open..."); 
 File FileDestination = myfileChooser.showOpenDialog(new Stage());
 String filename = FileDestination.getName();

 System.out.print(filename);

 // FileReader reads text files in the default encoding.
 FileReader fileReader = new FileReader(filename);

 // Always wrap FileReader in BufferedReader.
 BufferedReader bufferedReader = new BufferedReader(fileReader);
 String inputFileLine = null;
 double Mean = 0;
 int totalnumber = 0;


 while ((inputFileLine = bufferedReader.readLine()) != null) {
     Mean += Double.valueOf(inputFileLine);
     totalnumber++;
 }
 double showmean = Mean/totalnumber;
 mean.setText(String.valueOf(showmean));
}