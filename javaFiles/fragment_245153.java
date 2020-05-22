import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.*;
import java.util.List;

public class ClassSelection2 extends JFrame {
  private JList classList;
  private List<String> selectedItemsList = new ArrayList<>();

  private String[] classNames = {"Programming Foundations I",
      "Programming Foundations II",
      "Digital Design", "Computer Organization",
      "Programming Paradigms",
      "Honors Programming Paradigms", "Cluster Computing",
      "Software Engineering"};

  public ClassSelection2() {
    super("Classes Taken:");

    Container container = getContentPane();
    container.setLayout(new FlowLayout());

    classList = new JList(classNames);
    classList.setVisibleRowCount(5);
    classList.setFixedCellHeight(45);
    classList.setFixedCellWidth(450);

    classList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    classList.addListSelectionListener(new ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
          selectedItemsList.clear();
          selectedItemsList.addAll(classList.getSelectedValuesList());
        }
      }
    });

    container.add(new JScrollPane(classList));

    JButton button = new JButton("Print selected items");
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println(selectedItemsList);
      }
    });
    container.add(button, BorderLayout.SOUTH);

    setSize(600, 600);
    setVisible(true);

  }

  public static void main(String[] args) {
    ClassSelection2 application = new ClassSelection2();
  }
}