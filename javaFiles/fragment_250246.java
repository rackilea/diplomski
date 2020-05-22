public class Main implements ActionListener() {


    public Main() {
        new Class2(this);
    }

    public actionPerformed(Event e) {....}

}


public Class2 {

    ActionListener a;

    public Class2(ActionListener a) {
        this.a = a;

        ...
        ...
        button1.addActionListener(a);
        button2.addActionListener(a);

    }

}