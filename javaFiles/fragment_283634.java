import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


public class FooFrame
    extends JFrame
{
    private final JButton incrementBtn;
    private final JButton decrementBtn;
    private int value;

    {
        incrementBtn = new JButton("++");
        decrementBtn = new JButton("--");
    }

    private class IncrementListener
        implements ActionListener
    {

        public void actionPerformed(final ActionEvent evt)
        {
            increment();
        }

    }

    private class DecrementListener
        implements ActionListener
    {

        public void actionPerformed(final ActionEvent evt)
        {
            decrement();
        }

    }

    public void setupGUI()
    {
        final LayoutManager layout;

        layout = new FlowLayout();
        setLayout(layout);
        setupListeners();
        addComponents();
    }

    private void setupListeners()
    {
        incrementBtn.addActionListener(new IncrementListener());
        decrementBtn.addActionListener(new DecrementListener());
    }

    private void addComponents()
    {
        add(incrementBtn);
        add(decrementBtn);
    }

    private void increment()
    {
        value++;
        System.out.println("value = " + value);
    }

    private void decrement()
    {
        value--;
        System.out.println("value = " + value);
    }
}