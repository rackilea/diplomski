File userPath = new File(System.getProperty("user.dir"));
    for (String s : userPath.list())
        if (s.endsWith(".css")){
            MenuItem mi = new MenuItem(s);
            //using already made menu in my prog
            controller.mnuEdit.getItems().add(mi);
            mi.setOnAction((e)->{
                //always adding and removing from position 1
                //I already have a style sheet set at 0 
                scene.getStylesheets().remove(1);
                try {
                    scene.getStylesheets().add(1,new File(
                            System.getProperty("user.dir")+
                            System.getProperty("file.separator")+s)
                            .toURI().toURL().toExternalForm());
                } catch (MalformedURLException ex) {
                }
            });
        }