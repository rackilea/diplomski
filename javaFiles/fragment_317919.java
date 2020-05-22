// New int keeping track of background pos
private int arrPos;

public void init() {
    c=new Color[] {Color.red, Color.orange, Color.green, 
                   Color.pink, Color.blue, Color.black };
    // initialize the int
    arrPos = 0;
    btnNext = new Button("Next Color");
    btnNext.addActionListener(this);
    setLayout(new BorderLayout());
    add(btnNext, BorderLayout.SOUTH);
}

public void paint(Graphics g) { }

public void actionPerformed(ActionEvent e) {
    if(e.getSource() == btnNext) {
        // increment the background
        arrPos++;
        if (arrPos >= c.length) arrPos = 0;
        setBackground(c[arrPos]);
        repaint();
    }
}