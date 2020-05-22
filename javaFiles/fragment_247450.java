import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SplitButton extends JPanel {

    // The buttons.
    private JButton[] buttons;

    // Self-explanatory.
    public Color prim, trim;
    public Font font;

    public SplitButton(String[] labels, Color prim, Color trim, Font font) {
        super();

        this.prim = prim;
        this.trim = trim;
        this.font = font;

        // Evenly lays out buttons evenly in a row.
        GridLayout grid = new GridLayout(1, labels.length);
        grid.setHgap(0);
        grid.setVgap(0);
        setLayout(grid);

        setOpaque(false);
        initButtons(labels);
    }

    /**
    * Constructs and styles the button array.
    * @param labels The button labels.
    */
    private void initButtons(String[] labels) {
        buttons = new JButton[labels.length];
        for(int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(labels[i]);

            // Only outer borders are thick.
            int lb = (i == 0) ? 2 : 1;
            int rb = (i == buttons.length - 1) ? 2 : 0;

            buttons[i].setBorder(BorderFactory.createMatteBorder(2, lb, 2, rb, trim));
            buttons[i].setFocusPainted(false);
            buttons[i].setFont(font);
            buttons[i].setBackground(prim);
            buttons[i].setForeground(trim);
            add(buttons[i]);
        }
    }

    /**
    * Enable/disable the buttons.
    * @param enabled Is the button enabled?
    */
    public void setEnabled(boolean enabled) {
        if(buttons != null)
            for(int i = 0; i < buttons.length; i++)
                buttons[i].setEnabled(enabled);
    }

    /**
    * Listen to all the buttons.
    * @param listener The listening object.
    */
    public void addActionListener(ActionListener listener) {
        if(buttons != null)
            for(int i = 0; i < buttons.length; i++)
                buttons[i].addActionListener(listener);
    }
}