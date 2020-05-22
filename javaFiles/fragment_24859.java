com.sun.javafx.css.StyleManager.errorsProperty().addListener((ListChangeListener<? super CssError>) c -> {
        while(c.next()) {
            for(CssError error : c.getAddedSubList()) {
                // maybe you want to check for specific errors here
                System.out.println(error.getMessage());
            }
        }
    });