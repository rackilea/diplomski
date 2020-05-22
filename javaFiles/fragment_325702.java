VBox vlay = new VBox(10);

ChoiceBox<Integer> c1[] = new ChoiceBox[10];

InvalidationListener listener = o -> {
    int sumofc = 0;
    for (ChoiceBox<Integer> cb : c1) {
        Integer value = cb.getValue();
        if (value != null) {
            sumofc += value;
        }
    }

    // do something with sumofc
    System.out.println(sumofc);
};

for (int x = 0; x < c1.length; x++) {
    c1[x] = new ChoiceBox<>();
    c1[x].getItems().addAll(1, 2, 3);
    vlay.getChildren().add(c1[x]);
    c1[x].valueProperty().addListener(listener);
}