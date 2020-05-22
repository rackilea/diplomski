import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// I didn't seem to see anything like this with a quick look-through.
// anybody else know differently?
public class ComponentUpdater implements ActionListener {

    private static List<Component> componenets = new ArrayList<Component>();

    public void addComponent(Component component) {
        componenets.add(component);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        for(Component component : componenets) {
            component.repaint();
        }
    }
}