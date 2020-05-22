public void onClick(View v) {
    if(btn == v){
        double r = Double.parseDouble(edit.getText().toString());
        Computations c = new Computations();
        crf.setText("Circumference: " + c.circumference(r));
        area.setText("Area: " + c.area(r));
    }
  }