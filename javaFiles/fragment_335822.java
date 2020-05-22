public void initialize() {
        tp1.setValue(LocalTime.of(11, 00));
        tp2.setValue(LocalTime.of(11, 00));

        String tf1Text = "11:00";   // added the initial value 
        tf1.setText(tf1Text);
        tf1.setEditable(false);

       /*Passing the initial String here instead of the updated value */
        ChangeListener<Object> listener = (obs, oldValue, newValue) -> 
        update(tp1.getValue().toString(), tp2.getValue().toString(), tf1Text , tf1);  

        tp1.valueProperty().addListener(listener);
        tp2.valueProperty().addListener(listener);

    }

    public void update (String t1, String t2, String tf, TextField textField) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime parseTime1 = LocalTime.parse(t1,format);
        LocalTime parseTime2 = LocalTime.parse(t2,format);

        long diffT1AndT2 = ChronoUnit.MINUTES.between(parseTime1, parseTime2);

        LocalTime parseTime3InTextField = LocalTime.parse(tf,format);
        LocalTime add = parseTime3InTextField.plusMinutes(diffT1AndT2);
        tf1.setText(add.toString());
    }   
}