public Grid(int size) {
    if(size < 0) {
        throw new IllegalArgumentException("cannot create a grid with a negative size");
    } 
    setLayout(new GridLayout(size, size));
    grid = new JButton[size][size];
}