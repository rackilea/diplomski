for (int i = 0; i < this.cars.length; i++) {
    if (this.cars[i] != null && this.cars[i].getCarNum() == CarNum) {
        for (int j = i+1; j < this.cars.length; j++) { // This loop will shift the 
            this.cars[j-1] = this.cars[j];             // whole list down one when
        }                                              // a duplicate is found,
                                                       // overwriting it.
        i--;              // sets the index back to recheck the shifted list.
        this.noOfCars--;  // You removed one duplicate by overwriting it
    }
}