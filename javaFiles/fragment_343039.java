boolean contains = false;
for (int[] element : megaData) { // iterating over the list
    if (Arrays.equals(element, dataCheck)) {
        contains = true;
        break;
    }
}

if (contains) {
    System.out.println("A copy has been found");
} else {
    System.out.println("No copy found");
}