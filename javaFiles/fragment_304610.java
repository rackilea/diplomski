public String toString() {
    String output = "";
    for (int i = 0; i < this.cars.length; i++) {
        if (this.cars[i] != null) {
            output += "" + this.cars[i].toString() + "\n";
        } else {
            // condition that the i-th car is null
            output += "null\n"; // one possible approach
            // you could also do nothing and your toString would output just the non-null cars
         }
    }
    return output;
}