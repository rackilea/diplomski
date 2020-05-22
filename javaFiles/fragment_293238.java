boolean found = false;
for (int i = 0; i < array.length; i++) {
    if (numberIn == array[i]) {
        found = true;
        break;
    }
}  

if (!found) {
    System.out.println("WRONG!!!!!");
}