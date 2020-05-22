import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListModel;

public class ArticleTask2 extends JFrame {
    private static final long serialVersionUID = -1058351261839501095L;
    private JPanel mainPanel = new JPanel();
    private JButton button = new JButton("Delete");
    private DefaultListModel<String> model = new DefaultListModel<String>();
    private JList<String> choice;

    public ArticleTask2() {
        mainPanel.setLayout(new BorderLayout());
        add(mainPanel);
        updateList();
        mainPanel.add(choice, BorderLayout.CENTER);
        mainPanel.add(button, BorderLayout.SOUTH);
        button.addActionListener(new MyListener());
        setSize(400, 200);
        setResizable(false);
        setTitle("Delete article");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public  void updateList() {
        try {
            model.addElement("1");
            model.addElement("2");
            model.addElement("3");
            choice = new JList<String>(model);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public class MyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                DefaultListModel<String> model = (DefaultListModel<String>)choice.getModel();
                model.remove(choice.getSelectedIndex());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new ArticleTask2();
    }
}