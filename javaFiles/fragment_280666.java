import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFileChooser fc = new JFileChooser();
                List<JLabel> labels = findAll(JLabel.class, fc);

                JCheckBox cb = new JCheckBox("Open file after saving");
                JLabel fileFormatLabel = null;
                for (JLabel label : labels) {
                    if ("File Format:".equals(label.getText())) {
                        fileFormatLabel = label;
                    }
                }
                System.out.println(fileFormatLabel);
                if (fileFormatLabel != null) {
                    Container parent = fileFormatLabel.getParent();
                    parent.add(cb);
                }

                fc.showOpenDialog(null);
            }
        });
    }

    public <T extends Component> List<T> findAll(Class<? extends T> aClass, Container parent) {
        List<T> matches = new ArrayList<>();

        for (Component child : parent.getComponents()) {
            if (aClass.isInstance(child)) {
                matches.add((T) child);
            }
            if (child instanceof Container) {
                matches.addAll(findAll(aClass, (Container) child));
            }
        }

        return matches;
    }

}