for(int i = 0; i < 20; i++) {
  for(int j = 0; j < 20; j++) {
     for(int k = 0; k < 20; k++) {
        // Go through each value.
        int output = (-25 * i) + (14 * j) + (-8 * k);
        // Plug the values into the formula.
        if(output == -77) {
            // Test and output.
            System.out.println("i = " + i + ", j = " + j + ", k = " + k);
        }
     }
  }
}