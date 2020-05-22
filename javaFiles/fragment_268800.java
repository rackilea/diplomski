private void changeRowValue(double[] data, double oldVal, double newVal){
    for (int i = 0; i < data.length; i++){
      if(data[i, 0] == oldVal){
         data[i, 0] = newVal;
      }
    }
 }