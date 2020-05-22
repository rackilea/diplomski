for (double[] result :  results) {
     //here result is just a copy of results[0], results[1] and on...
     //if you modify value of result i.e. assigning a new value
     //you're just changing the value of the current variable
     //note that if you modify an object inside the variable is reflected
     //since you're updating the state of the reference, which is valid
}