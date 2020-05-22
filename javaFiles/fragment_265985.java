int[] arr1 = { 1, 6, -6, -9, 3, 4, -8, -7 };
int[] arr2 = { 5, 3, 2, 1, 70, 6, 7, -9, 99, 81 };

// Create a boolean array with the same length as the first array.
boolean[] duplicates = new boolean[arr1.length];
// Counter for how many duplicates we found.
int numDuplicates = 0;

// Loop through the first array and get all duplicates.
for (int i = 0; i < arr1.length; i++) {
    boolean duplicate = false;
    for (int j = 0; j < arr2.length; j++) {
        if (arr1[i] == arr2[j]) {
            duplicate = true;
            numDuplicates++;
            break;
        }
    }
    duplicates[i] = duplicate;
}

// The length of the merged array will be the two lengths subtracted by the number of
// duplicates we found.
int[] mergedArray = new int[arr1.length + arr2.length - numDuplicates];
int index = 0;

// loop through the first array. Don't add it to the merged array if it is a duplicate.
for (int i = 0; i < arr1.length; i++) {
    if (!duplicates[i]) {
        mergedArray[index] = arr1[i];
        index++;
    }
}

// loop through the second array and add all items.
for (int i = 0; i < arr2.length; i++) {
    mergedArray[index] = arr2[i];
    index++;
}

// optional. sort array
Arrays.sort(mergedArray);

System.out.println(Arrays.toString(mergedArray));