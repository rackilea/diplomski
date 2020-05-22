public void example() {
    String str;
    switch (1) {
    case 1:
        str = "test";// If I initalize here then there is problem since
                        // scope is limited to only this case
        str.toString();
        break;

    default:
        str.toString();// Compilation error here.
        break;
    }
}

public void example() {
    String str = "test";
    switch (1) {
    case 1:
        str.toString();
        break;

    default:
        str.toString();// No error because scope of initialisation is whole
                        // method
        break;
    }
}