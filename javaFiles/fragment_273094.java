import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class WorkerExample
{

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WorkerGui gui = new WorkerGui();
                JFrame frame = gui.createFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}



class WorkerGui
{
    public static final String ADD_NEW_ROW_PROPERTY = "ADD_NEW_ROW";
    private static final Dimension SUB_PANEL_SIZE = new Dimension(350, 50);
    private JButton button;
    private JComponent labelComponent;
    private JScrollPane scroller;
    int labelCount = 0;

    private List<String> loadXml() {
        try {
            // pretend to load a large XML file...
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ex) {
            Logger.getLogger(WorkerGui.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<String> dataList = new ArrayList<String>();

        for (int i = 1; i <= 20; i++) {
            dataList.add("Important data " + i);
        }

        return dataList;
    }

    ProgressMonitor monitor = null;


    class XmlWorker extends SwingWorker<Void, Void> {

        @Override protected Void doInBackground() throws Exception {
            monitor.setProgress(2);
            List<String> rows = loadXml();

            final int denom = rows.size();

            int i = 1;
            Random random = new Random();
            for (String string : rows) {
                if (monitor.isCanceled()) {
                    break;
                }
                Thread.sleep(random.nextInt(2000));
                firePropertyChange(ADD_NEW_ROW_PROPERTY, null, string);
                setProgress((int)(100 * (i / (double)denom)));
                i++;
            }
            return null;
        }

        @Override protected void done() {
            // restore the button
            button.setEnabled(true);
            button.requestFocus();
        }
    }


    final PropertyChangeListener listener = new PropertyChangeListener() {
        @Override public void propertyChange(PropertyChangeEvent evt) {
            if ("progress".equals(evt.getPropertyName())) {
                monitor.setProgress((Integer)evt.getNewValue());
            } else if (ADD_NEW_ROW_PROPERTY.equals(evt.getPropertyName())) {
                addRow((String)evt.getNewValue());
            }
        }
    };

    private void doWork() {
        monitor = new ProgressMonitor(labelComponent.getTopLevelAncestor(), "Loading XML", "", 0, 100);
        monitor.setProgress(0);
        monitor.setMillisToPopup(0);
        monitor.setMillisToDecideToPopup(0);
        XmlWorker worker = new XmlWorker();
        worker.addPropertyChangeListener(listener);
        worker.execute();
    }

    private JComponent setupGui() {
        labelComponent = Box.createVerticalBox();
        scroller = new JScrollPane(labelComponent,
                                    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
                                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JPanel buttonPanel = new JPanel();
        button = new JButton("Do it!");
        buttonPanel.add(button);
        button.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                button.setEnabled(false);
                clear();
                doWork();
            }
        });

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(scroller, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        return mainPanel;
    }

    public JFrame createFrame() {
        JFrame frame = new JFrame("Hello!");
        frame.setSize(400, 400);
        JComponent component = setupGui();
        frame.add(component);
        return frame;
    }

    public void clear() {
        labelComponent.removeAll();
        labelCount = 0;
        scroller.validate();
        scroller.getTopLevelAncestor().repaint();
    }

    /**
     * Creates a JLabel out of the data and adds it to the main panel.
     * Must be called on Event Dispatch Thread!!
     * @param data  the data to add, could be any class.
     */
    public void addRow(String data) {
        if (labelCount > 0) {
            labelComponent.add(Box.createVerticalStrut(10));
        }
        labelCount++;

        final JLabel label = new JLabel(data);
        JPanel panel = new JPanel();
        panel.add(label);

        panel.setPreferredSize(SUB_PANEL_SIZE);
        panel.setMaximumSize(SUB_PANEL_SIZE);
        panel.setBorder(BorderFactory.createLineBorder(Color.BLUE));

        labelComponent.add(panel);
        scroller.validate();
        panel.scrollRectToVisible(panel.getBounds());
    }
}