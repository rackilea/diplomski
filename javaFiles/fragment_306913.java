public class LabelCreator /*extends JLabel*/ {
    /*private static final long serialVersionUID = 1L;*/
    /*private static JLabel label;*/

    public Component createLabel(JFrame frame, String text) {
        JLabel label = new JLabel(text);
        return frame/*.getContentPane()*/.add(label);
    }
}