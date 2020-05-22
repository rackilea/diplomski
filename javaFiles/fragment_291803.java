for (int row = 0; row < a.length; row++) {
    for (int column = 0; column < a[row].length; column++) {
        sum += a[row][column];
    }
}

average = (double) sum / (a.length * a[0].length);