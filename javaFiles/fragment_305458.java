int min = array[0];
for (int i : array) {
    if (i > min) {
        min = i;
    }
}

System.out.println("The min is: " + min);