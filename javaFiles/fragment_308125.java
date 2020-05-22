final List<String> values = Arrays.asList("", "X", "O");

for(int i=0; i<btn.length; i++){
    for(int j=0; j<btn.length;j++){
        final Button button = new Button("");

        button.setOnAction(event -> {
            int valueIndex = values.indexOf(button.getText());
            button.setText(values.get((valueIndex+1) % values.size()));
        });
        // Initializing 2D buttons with values i,j
        btn[i][j] = button;                      
        button.setPrefSize(35, 40);
        gridPane.add(button, i, j);
        // button.setDisable(false);
    }
}