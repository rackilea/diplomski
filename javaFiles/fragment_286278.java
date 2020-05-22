import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class MainPage extends JFrame {
    private static final String LOGIN_PANEL_ID = "Login panel";
    private static final String NOTEBOOK_ID = "Notebook tabbed pane";

    private JPanel mainPanel;
    private CardLayout cardLayout;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainPage frame = new MainPage();
                    frame.setResizable(false);
                    Image icon = new BufferedImage(1, 1,
                                                   BufferedImage.TYPE_INT_ARGB_PRE);
                    frame.setIconImage(icon);
                    frame.setTitle("Notebook");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     * @throws IOException
     */
    public MainPage() throws IOException {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 560, 390);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        mainPanel.add(createLoginPanel(), LOGIN_PANEL_ID);
        mainPanel.add(new NotebookTab(), NOTEBOOK_ID);

        getContentPane().add(mainPanel);
    }

    private JPanel createLoginPanel() throws IOException {
        JPanel loginPanel = new JPanel(new BorderLayout());

        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.PAGE_AXIS));

        JLabel lblEnterPassword = new JLabel("Enter Password");
        lblEnterPassword.setForeground(Color.LIGHT_GRAY);
        lblEnterPassword.setBackground(Color.DARK_GRAY);
        lblEnterPassword.setOpaque(true);
        lblEnterPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblEnterPassword.setMaximumSize(new Dimension(100, 16));
        lblEnterPassword.setAlignmentX(Component.CENTER_ALIGNMENT);

        JTextField textField = new JPasswordField(10);
        textField.setMaximumSize(new Dimension(100, 16));
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);

        passwordPanel.add(Box.createRigidArea(new Dimension(0, 42)));
        passwordPanel.add(lblEnterPassword);
        passwordPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        passwordPanel.add(textField);

        loginPanel.add(passwordPanel, BorderLayout.NORTH);

        Action loginAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (new Security().checkPassword(textField.getText())) {
                    System.out.println("working");
                    cardLayout.show(mainPanel, NOTEBOOK_ID);
                }
            }
        };

        textField.addActionListener(loginAction);

        String imagePath = "C:\\Users\\Gianmarco\\workspace\\" +
                           "notebook\\src\\notebook\\cool_cat.jpg";
        BufferedImage bufferedImage = ImageIO.read(new File(imagePath));
        JLabel imageLabel = new JLabel(new ImageIcon(bufferedImage));

        loginPanel.add(imageLabel, BorderLayout.CENTER);

        return loginPanel;
    }
}