import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DemoColorChooser {

    public static void main(String[] args) {
        final JColorChooser chooser = new JColorChooser();
        chooser.setColor(Color.BLUE);
        chooser.getSelectionModel().addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent arg0) {
                Color color = chooser.getColor();
                System.out.println(color);
            }
        });
        JDialog dialog = JColorChooser.createDialog(null, "Color Chooser",
                true, chooser, null, null);
        dialog.setVisible(true);
        System.exit(0);
    }
}