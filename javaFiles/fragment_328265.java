import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

public final class TitledBorderDemo {
    private static void createAndShowGUI(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.add(new TitledLabel(String.valueOf(0)));
        frame.pack();
        frame.setVisible(true);
    }

    private static class TitledLabel extends JLabel{
        private static final long serialVersionUID = 1L;
        private static final String TITLE = "aaa";

        TitledLabel(String text){
            super(text);
            setAlignmentX(Component.CENTER_ALIGNMENT);
            setFont(new Font("Arial", Font.PLAIN, 280));
            setBorder(new TitledBorder(TITLE){
                private static final long serialVersionUID = 1L;

                @Override
                public Insets getBorderInsets(Component c, Insets insets){
                    // arbitrary insets for top and bottom.
                    return new Insets(insets.top - 45, insets.left, insets.bottom - 55, insets.right);
            }});

        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                createAndShowGUI();             
            }
        });
    }
}