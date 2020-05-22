public class SampleGUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JOptionPane optionPane = new JOptionPane("Eggs are not supposed to be green.");
                JDialog generatedDialog = optionPane.createDialog("Message");
                generatedDialog.setVisible(true);
            }
        });
    }
}