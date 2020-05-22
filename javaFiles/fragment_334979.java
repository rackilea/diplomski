public void start(Stage primaryStart) throws Exception{
    window = primaryStart;
    window.setTitle("Minesweeper (Eventually)");
    //GridPane with 10px padding around edge
    GridPane grid = new GridPane();
    grid.setPadding(new Insets(10, 10, 10, 10));
    for(int i = 0; i < 5; i++){
        for(int j = 0; j<5; j++){
            Button button = new Button("[]");
            button.setOnAction(e -> {System.out.println("Something");});
            GridPane.setConstraints(button, i,j);
            grid.getChildren().add(button);
        }
    }
    Scene scene = new Scene(grid, 300, 200);
    window.setScene(scene);
    window.show();

}