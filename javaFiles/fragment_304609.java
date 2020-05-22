int writeIndex = 0;
for (int readIndex = 0; readIndex < this.cars.length; readIndex++) {
    if (this.cars[readIndex] != null && this.cars[readIndex].getCarNum() == CarNum) {
        // pass on this because nextIndex should track only the valid cars.
    } else {
        this.cars[writeIndex++] = this.cars[readIndex];
    }
    if (writeIndex < readIndex) {
        this.cars[i] = null;
    }
}