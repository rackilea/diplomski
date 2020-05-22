import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.swing.*;

@SuppressWarnings("serial")
public class UserInterface extends JFrame {

    public UserInterface() {
        initUI();
    }

    @SuppressWarnings("unchecked")
    private void initUI() {

        UserInteractionHandler uiHandler = new UserInteractionHandler();

        setTitle("Steam Stats");
        // !! setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(0, 1));

        JLabel header = new JLabel("Steam Stats", SwingConstants.CENTER);
        header.setFont(new Font("trebuchet ms", Font.BOLD, 20));
        panel.add(header);

        String userId = JOptionPane.showInputDialog("Steam ID 64");
        String appId = JOptionPane.showInputDialog("App Id of Game");

        Map<String, Integer> allAchievements = uiHandler.getAllAchievements(
                appId, userId);

        DefaultListModel<MyPair> listModel = new DefaultListModel<>();
        JList<MyPair> pairList = new JList<>(listModel);
        pairList.setCellRenderer(new MyPairRenderer());
        pairList.setVisibleRowCount(20);

        @SuppressWarnings("rawtypes")
        Iterator it = allAchievements.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> pair = (Map.Entry<String, Integer>) it
                    .next();

            MyPair myPair = new MyPair(pair.getKey(), pair.getValue());
            listModel.addElement(myPair);

            it.remove();
        }

        //!! JScrollPane scrollPanel = new JScrollPane(panel);
        JScrollPane scrollPanel = new JScrollPane(pairList);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(header, BorderLayout.PAGE_START);
        mainPanel.add(scrollPanel);

        getContentPane().add(mainPanel, BorderLayout.PAGE_START);
        pack(); // !!

    }

    public static void runUi() {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                UserInterface ui = new UserInterface();
                ui.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        UserInterface.runUi();
    }
}

class MyPair {
    private String name;
    private int value;
    public MyPair(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

}

class MyPairRenderer implements ListCellRenderer<MyPair> {
    private JPanel panel = new JPanel(new GridLayout(1, 2, 5, 5));
    private JLabel nameLabel = new JLabel();
    private JLabel valueLabel = new JLabel();

    public MyPairRenderer() {
        panel.add(nameLabel);
        panel.add(valueLabel);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends MyPair> list,
            MyPair value, int index, boolean isSelected, boolean cellHasFocus) {
        if (value != null) {
            nameLabel.setText(value.getName());
            valueLabel.setText("" + value.getValue());
        }
        return panel;
    }

}