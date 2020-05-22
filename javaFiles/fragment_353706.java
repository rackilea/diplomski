StringBinding binding = Bindings.createStringBinding(
            () -> MessageFormat.format("~Width=[{0}],Height=[{1}]~", primaryStage.getWidth(), primaryStage.getHeight()),
            primaryStage.widthProperty(),
            primaryStage.heightProperty());

label.textProperty().bind(binding);