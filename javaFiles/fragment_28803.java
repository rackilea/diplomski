double minimum_angle = Double.MAX_VALUE;
for(int counter = 0; counter < data.length; counter++) {
    if(data[counter] < minimum_angle) {
        minimum_angle = data[counter];
    }
}