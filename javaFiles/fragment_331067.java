ArrayList<ImageView> leftScoringNodeBgArray = new ArrayList<>();
SequentialTransition seq = new SequentialTransition();

for (int i = 0; i < 5; i++) {
    leftScoringNodeBgArray.add(new ImageView(leftScoringBgImage));

    TranslateTransition tr = new TranslateTransition();
    tr.setNode(leftScoringNodeBgArray.get(0));
    tr.setToX(300 + i * 100);
    tr.setCycleCount(1);
    seq.getChildren().add(tr);
}