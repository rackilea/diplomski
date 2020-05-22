try {
        FXMLLoader loader = new FXMLLoader();
        loader.setController(new MainMenuController());
        loader.setLocation(getClass().getResource("/io/ironbytes/corkscrew/views/MainMenu.fxml"));
        root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();            
    } catch (Exception e) {
        e.printStackTrace();
    }
}`