class JButtonClass extends JButton {
    JButtonClass(HeadClass headClass) {
        headClass.jbtn = this;
        this.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                headClass.someFunction();
            } 
        });
    }
}

class HeadClass {
    HashMap hashMap;
    JButtonClass jbtn;

    void someFunction() {
        // do stuff with jbtn
    }
}

public static main(String[] args) {
    new JButtonClass(new HeadClass());
}