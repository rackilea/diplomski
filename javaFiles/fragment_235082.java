import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class BackgroundWorkerFrame extends javax.swing.JFrame {
    public BackgroundWorkerFrame() {
        initComponents();
        jList.setModel(new DefaultListModel());
    }

    private void jButtonGoActionPerformed(ActionEvent evt) {                                          
        Thread t = new Thread(new WorkerRunnable());
        t.start();
    }                                         

    public class WorkerRunnable implements Runnable {
        public void run() {
            System.out.println("Working hard...");
            sleep(1000);
            ArrayList<Integer> list = new ArrayList();
            for (int i = 0; i < 5; i++) {
                list.add((int) (Math.random() * 100));
            }
            System.out.println("Updating GUI...");
            SwingUtilities.invokeLater(new UpdateRunnable(list));
        }
    }

    public class UpdateRunnable implements Runnable {
        private final ArrayList<Integer> list;
        private UpdateRunnable(ArrayList<Integer> list) {
            this.list = list;
        }
        public void run() {
            DefaultListModel model = (DefaultListModel) jList.getModel();
            model.clear();
            for (Integer i : list) {
                model.addElement(i);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jButtonGo = new JButton();
        jScrollPane = new JScrollPane();
        jList = new JList();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jButtonGo.setText("Go");
        jButtonGo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonGoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonGo, BorderLayout.PAGE_START);

        jScrollPane.setViewportView(jList);

        getContentPane().add(jScrollPane, BorderLayout.CENTER);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-309)/2, (screenSize.height-338)/2, 309, 338);
    }// </editor-fold>

    public static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BackgroundWorkerFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    JButton jButtonGo;
    JList jList;
    JScrollPane jScrollPane;
    // End of variables declaration
}