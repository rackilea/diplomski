int[] input = {1, 3, 4, 1, 2, 2, 4, 5, 6, 6};

int[] result = new int[input.length];
int resultSize = 0;

for (int anInput : input) {
    boolean found = false;
    for (int j = 0; j < resultSize; j++) {
        if (anInput == result[j]) { // already exists
            found = true;
            break;
        }
    }
    if (!found) { // add
        result[resultSize++] = anInput;
    }
}

// copy to new result only real values
int[] newResult = new int[resultSize];
System.arraycopy(result, 0, newResult, 0 , resultSize);

System.out.println("result = " + Arrays.toString(newResult));