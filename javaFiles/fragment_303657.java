Test(){

    setLayout(new GridLayout(1, 2));   // sets a Grid Layout with 1 row and 2 columns
    add(name);

    JScrollPane scroll = new JScrollPane(ta);
    ta.setLineWrap(true);
    add(scroll);


}

public static void main(String[] args) {
    JFrame frame = new Test();
    frame.setSize(435, 400);
    frame.setTitle("Test");
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    frame.setVisible(true);
}