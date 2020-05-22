btn.setText("Roll Die");
btn.setOnAction((ActionEvent event) -> {
    btn.setDisable(true);//Disable Button
    Random random = new Random();
    int gekozen = Integer.parseInt(tf3.getText());

    int numTempValues = random.nextInt(20) + 1 ;
    int[] tempValues = random.ints(1, 7).limit(numTempValues).toArray();
    int finalDieValue = tempValues[numTempValues - 1];
    Timeline timeline = new Timeline() ;
    for (int i = 0 ; i < tempValues.length ; i++) {
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.3).multiply(i+1), actionEvent -> {
            System.out.println(tempValues[i]);
            die.setDieFace(tempValues[i]);
        });
        timeline.getKeyFrames().add(keyFrame);
    }

    timeline.setOnFinished(actionEvent -> {
        btn.setDisable(false);//Enable Button
        System.out.println("You rolled: "+finalDieValue);
    });

    timeline.play();


});