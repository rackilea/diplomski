JLabel lbl = new JLabel("Hello"););
Class2.process(lbl);


public class Class2 {
    public static void process(JLabel lbl) {
        // I want to control lbl from Class1 class inside this method like
        lbl.setVisible(false); // this will change your Class1 Jlabel
    }