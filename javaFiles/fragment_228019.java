for (int i = 9; i >= 0; i--) {

    // now the trick to making a "zig-zag" is to alternate between two ways
    // of printing out each row. if i is even, you print out from right to left

    if (i % 2)
        for (int j = 9; j >= 0; j--)
            cout << numbers[i][j] << "\t";

    // and if i is odd, you print it out from left to right
    else
        for (int j = 0; j < 10; j++)
            cout << numbers[i][j] << "\t";

    cout << endl;

}