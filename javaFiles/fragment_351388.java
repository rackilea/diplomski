Integer[] oldArray = ...;

// Step 2
int count = 0;
for (Integer i : oldArray) {
    if (i != null) {
        count++;
    }
}

// Step 3
Integer[] newArray = new Integer[count];

// Step 4
int index = 0;
for (Integer i : oldArray) {
    if (i != null) {
        newArray[index++] = i;
    }
}