import java.awt.Component;
import java.util.List;
import javax.swing.*;

public class SortSwingWorker extends SwingWorker<Object, Object> {

    private JPanel sortPanel;
    private StickNumber[] listOfNumbers;

    public SortSwingWorker(JPanel sortPanel) {
        this.sortPanel = sortPanel;
        Component[] components = sortPanel.getComponents();
        listOfNumbers = new StickNumber[components.length];
        for (int i = 0; i < components.length; i++) {
            listOfNumbers[i] = (StickNumber) components[i];
        }
    }

    @Override
    protected Object doInBackground() throws Exception {
        boolean swapped = true;
        int j = 0;
        StickNumber tmp;

        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < listOfNumbers.length - j; i++) {
                if (listOfNumbers[i].getValue() > listOfNumbers[i + 1].getValue()) {
                    tmp = listOfNumbers[i];
                    listOfNumbers[i] = listOfNumbers[i + 1];
                    listOfNumbers[i + 1] = tmp;
                    swapped = true;
                    publish(null);
                }
            }
        }
        return null;
    }

    @Override
    protected void process(List<Object> list) {
        sortPanel.validate();
        sortPanel.repaint();
    }

    //dummy class
    private class StickNumber extends Component {

        public Integer getValue() {
            return null;
        }
    }
}