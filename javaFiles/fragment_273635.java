DynamicString() {
    jp=new JPanel(sl);
    b1=new JButton("SHOW");
    b1.addActionListener(this);
    jp.add(b1,"newline, w 100!, h 100!"); 

    b2=new JButton("Button 2");
    jp.add(b2,"w 100!, h 100!, hidemode 0"); // use whatever hidemode mode that's the more convenient for you
    b2.setVisible(false);

    jf.setContentPane(jp);
    jf.setVisible(true);

    }

public void actionPerformed(ActionEvent ae) {
    b2.setVisible(true);
}