import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.List;

public class ClassSelection extends JFrame {
  private JList classList;
  private String[] classNames = {"Programming Foundations I",
      "Programming Foundations II",
      "Digital Design", "Computer Organization",
      "Programming Paradigms",
      "Honors Programming Paradigms", "Cluster Computing",
      "Software Engineering"};

  public ClassSelection() {
    super("Classes Taken:");

    Container container = getContentPane();
    container.setLayout(new FlowLayout());

    classList = new JList(classNames);
    classList.setVisibleRowCount(5);
    classList.setFixedCellHeight(45);
    classList.setFixedCellWidth(450);

    classList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

    container.add(new JScrollPane(classList));

    JButton button = new JButton("Print selected items");
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        List selectedItems = classList.getSelectedValuesList();
        System.out.println(selectedItems);
      }
    });
    container.add(button, BorderLayout.SOUTH);

    setSize(600, 600);
    setVisible(true);

  }

  public static void main(String[] args) {
    ClassSelection application = new ClassSelection();
  }
}