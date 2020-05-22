void change(){
        try{
            Node node= ... ;// any node in your scene will do....
            Stage   stage=(Stage) node.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("astrolabe/astrolabe_intro.fxml"));/* Exception */

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setFullScreenExitHint("");

            stage.show();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }


    }