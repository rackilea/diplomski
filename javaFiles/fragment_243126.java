private double[] maxValues = {0, 0, 0, 0};
private double[] minValues = {0, 0, 0, 0};
private void calculateMinAndMax(String[] line) {
    for (int i = 0; i < line.length; i++) {
            //check the max value
            double currentValue = Double.Double.parseDouble(line[i]);
            if(currentValue > maxValues[i] ) {
                maxValues[i] = currentValue;
            }

            //check the min value
            if(currentValue < minValues[i]) {
                minValues[i] = currentValue;
            }
    }
}