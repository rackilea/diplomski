tf = new TextField();
tf.setMaxWidth(Double.MAX_VALUE);
sp = new Spinner<Integer>(0, 3, 1);
sp.setMaxWidth(Double.MAX_VALUE);
dp = new DatePicker(LocalDate.now());
dp.setMaxWidth(Double.MAX_VALUE);

vBox.setFillWidth(true);

vbox.getChildren().addAll(tf, sp, dp);