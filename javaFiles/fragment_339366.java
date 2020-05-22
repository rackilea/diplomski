for (int i = 0; i < arr.length; i++) { // check the array arr to                
    if (arr[i] == charVal) { // if it exists, set answer to true
        answer = true;
    }
}

// if answer is false then we didn't find it and we can add it.
if (answer == false) {
    arr2[go] = enterValue; 
}

// check the arr2
for (String c : arr2) {
    System.out.print(c);
}