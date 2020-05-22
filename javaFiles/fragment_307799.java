public class TestFrame extends javax.swing.JFrame {

    javax.swing.JLabel label;

    public TestFrame() {
        initComponents();
        label=sampleLabel;
    }

    private void initComponents() {

        sampleLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sampleLabel.setText("anotherText");
        add(sampleLabel);
        pack();
    }

    private javax.swing.JLabel sampleLabel;
}