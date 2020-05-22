public Squares(){
    this.setLayout(new GridLayout(3,3));
    this.setBorder(new LineBorder(Color.BLACK,2));
    for(int i = 0; i<CELL_COUNT; i++){
        cells[i] = new Cell();
        this.add(cells[i]);
    }
}