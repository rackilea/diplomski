@Override
public void start(Stage stage){
    Parent root = null;
    try {
        root = FXMLLoader.load(getClass().getResource("wrongFileName.fxml"));
    } catch (IOException ex) {
        System.out.println("SomeTextForCheck");
        ex.printStackTrace() 
    }
    catch(RuntimeException ex) {
        System.out.println("SomeTextForCheck");
        ex.printStackTrace()
    }
    catch(Exception ex) {
        System.out.println("SomeTextForCheck");
        ex.printStackTrace()  
    }
}