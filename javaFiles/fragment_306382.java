public class Generator  extends JDialog {
    private String format;
    private JButton generateBtn;

    public Generator () {
        setModal(true);
        generateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // create format string
                setVisible(false);
            }
         });
    }

    public String start() {
        setVisible(true);
        return format;
    }
 }