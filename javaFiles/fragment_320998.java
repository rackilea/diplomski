ScaleTransition ft = new ScaleTransition(Duration.millis(3000));
ft.setByX(1.5);
ft.setByY(1.5);
ft.setNode(firstImage);

ScaleTransition st = new ScaleTransition(Duration.millis(3000));
st.setNode(secondImage);
st.setByX(1.5);
st.setByY(1.5);

SequentialTransition sequence = new SequentialTransition(ft, st);
sequence.play();