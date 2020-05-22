public String[] add(String[] arr, String el, int idx) {
  if (idx >= arr.length) { //uh-oh, out of bounds incoming
    String[] newArr = new String[arr.length * 2]; //let's grow our array by a factor of 2
    for (int i = 0; i < arr.length; i++) { //copy the old values in
      newArr[i] = arr[i];
    }
    newArr[idx] = el; //add in the new value
    return newArr; 
  }
  else {
    arr[idx] = el;
  }
  return arr;
}