timeline.setCycleCount(random.nextInt(20) + 1);
timeline.play();
timeline.setOnFinished(actionEvent -> {
    btn.setDisable(false);//Enable Button
    int dieValue = die.getDieFace();
    System.out.println(dieValue);
});