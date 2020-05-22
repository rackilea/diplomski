// For each row=maxHeight ... 1
for (int height = maxHeight; height >= 0; --height) {
    printFloor(w0, '*'); // print width many chars

    if (tower1 >= height) { // if tower1 is at height row
        printFloor(w1, '*');
    } else {
        printFloor(w1, ' ');
    }

    if (tower2 >= height) { // if tower2 is at height row
        printFloor(w2, '*');
    } else {
        printFloor(w2, ' ');
    }

    System.out.println(); // Start next height
}