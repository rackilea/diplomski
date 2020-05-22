private JFrame f;
public Grid(String fname, int row, int column, int d) {
    f = new JFrame(fname);
    f.setLayout(new GridLayout(row,column));
    f.setSize(row*d,column*d);
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    addContent(row,column,d);
}

public void open() {
    f.setVisible(true);
}

private void addContent(int r, int c, int d) {
    Border border = BorderFactory.createLineBorder(Color.black, 2);
    for (int i = 0 ; i < r ; i++) {
        for (int j = 0 ; j < c ; j++) {
            f.add(new JLabel(i+","+j) {{
                 setBorder(border);
                 setPreferredSize(new Dimension(d,d));
            }});
        }
    }
}
public static void main(String[] args) { 
    Grid grid = new Grid("Test", 5, 4, 50);
    grid.open();
}