MyObject objectToChange;

if (objectNo == 1) {
    objectToChange = object1;
} else if (objectNo == 2) {
    objectToChange = object2;
} else if (objectNo == 3) {
    objectToChange = object3;
} else {
    throw new IllegalArgumentException(Integer.toString(objectNo));
}

objectToChange.name = productName;