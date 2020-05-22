public class A extends JFrame {
     JTextField pA, pB;
     public String a1, b2;

     public A() {
        pA = new JTextField (10);
        pA.setEditable(false);
        pA.setText(a1);
        pB = new JTextField (10);
        pB.setText(b2);
        pB.setEditable(false);

        setLayout(new FlowLayout);

        add(pA);  
        add(pB);    
     }

     public void setPaText(String text) {
       pA.setText(text);
     }

     public void setPbText(String text) {
       pB.setText(text);
     }
 }