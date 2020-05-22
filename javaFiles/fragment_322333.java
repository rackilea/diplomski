import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

class Calculator extends JFrame {

    JButton add, sub, mul, div, sin, cos, tan, clear, negate, inverse, zero, one, two, three, four, five, six, seven, eight, nine, equalTo, percentage, sqrt;
    JTextField input;
    GridBagLayout gbl;

    private void addComponent(Component component, int gridx, int gridy, int gridwidth, int gridheight, Insets insets) {
        add(component, new GridBagConstraints(gridx, gridy, gridwidth, gridheight, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets, 0, 0));
    }

    Calculator() {
        //setSize(500,400);
        setLayout(gbl = new GridBagLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");
        sin = new JButton("sin");
        cos = new JButton("cos");
        tan = new JButton("tan");
        clear = new JButton("C");
        negate = new JButton("neg");
        inverse = new JButton("1/x");
        zero = new JButton("0");
        one = new JButton("1");
        two = new JButton("2");
        three = new JButton("3");
        four = new JButton("4");
        five = new JButton("5");
        six = new JButton("6");
        seven = new JButton("7");
        eight = new JButton("8");
        nine = new JButton("9");
        equalTo = new JButton("=");
        percentage = new JButton("%");
        sqrt = new JButton("sqrt");
        input = new JTextField(20);

        addComponent(input, 0, 0, 0, 1, new Insets(10, 10, 100, 4)); //tldr

        addComponent(add, 0, 1, 1, 1, new Insets(4, 4, 4, 4));
        addComponent(sub, 1, 1, 1, 1, new Insets(4, 4, 4, 4));
        addComponent(mul, 2, 1, 1, 1, new Insets(4, 4, 4, 4)); // this is not displayed
        addComponent(div, 3, 1, 1, 1, new Insets(4, 4, 4, 4));

        addComponent(sin, 0, 2, 1, 1, new Insets(4, 4, 4, 4));
        addComponent(cos, 1, 2, 1, 1, new Insets(4, 4, 4, 4));
        addComponent(tan, 2, 2, 1, 1, new Insets(4, 4, 4, 4)); // this is not displayed
        addComponent(clear, 3, 2, 1, 1, new Insets(4, 4, 4, 4));

        addComponent(negate, 0, 3, 1, 1, new Insets(4, 4, 4, 4)); // these 4 are not visible
        addComponent(inverse, 1, 3, 1, 1, new Insets(4, 4, 4, 4));
        addComponent(zero, 2, 3, 1, 1, new Insets(4, 4, 4, 4));
        addComponent(one, 3, 3, 1, 1, new Insets(4, 4, 4, 4));
        pack();
        setVisible(true);
    }

    public static void main(String... args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Calculator();
            }

        });
    }

}