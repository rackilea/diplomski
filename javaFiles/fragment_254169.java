private void layoutNodes() {
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(25,25,25,25));
    grid.add(scenetitle, 0, 0, 2, 1);
    grid.add(userName, 0, 1);
    grid.add(userTextField, 1, 1);
    grid.add(pw, 0, 2);
    grid.add(pwBox, 1, 2);
    grid.add(hbBtn, 1, 6);
    grid.add(actiontarget, 1, 6);
    BorderPane.setAlignment(grid, Pos.CENTER);

    this.setCenter(grid);
}