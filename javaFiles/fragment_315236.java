Validation<Integer> validation = new Validation<Integer>(5);
if(validation.greaterThan(3).isEqualTo(5).isOdd().isValid()) {
    //Do something for when value is valid
} else {
    //Do something for when value is invalid
}