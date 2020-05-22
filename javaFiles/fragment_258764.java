import java.awt.BorderLayout;
    import java.awt.CardLayout;
    import java.awt.Color;
    import java.awt.Dimension;
    import java.awt.FlowLayout;
    import java.awt.Font;
    import java.awt.GridBagConstraints;
    import java.awt.GridBagLayout;

    import javax.swing.BorderFactory;
    import javax.swing.BoxLayout;
    import javax.swing.JFrame;
    import javax.swing.JLabel;
    import javax.swing.JPanel;
    import javax.swing.SwingUtilities;    
    public class Main {
    //Settings Panel variables
    JLabel settingsTitle = new JLabel("Settings");

    public Main()
    {
        JPanel mainCard = new JPanel(new GridBagLayout());
        JPanel settingsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        settingsTitle.setFont(new Font("TimesRoman", Font.PLAIN, 35));
        settingsPanel.add(settingsTitle);

        final CardLayout layout = new CardLayout();
        final JPanel cards = new JPanel(layout);
        cards.add(mainCard, "2");

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1.0;
        c.weighty = 1.0;
        c.anchor = GridBagConstraints.LAST_LINE_START;
        c.fill = GridBagConstraints.NONE; //uneeded line because it's the default value, but it has to be NONE

        mainCard.add(settingsPanel, c);

       // settingsPanel.setPreferredSize(new Dimension(300, 425)); //the components inside settingsPanel will set its side
        settingsPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        layout.show(cards, "1");

        JFrame window = new JFrame("Test");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(cards);
        window.setSize(1280, 720); ///replace with window.pack()
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setVisible(true);

    }

    public static void main(String[] args)
    {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });

    }
}