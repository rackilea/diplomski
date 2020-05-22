import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FooWork {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            userFrame.main(args);
        });
    }
}

class NewWork extends JPanel {
    public NewWork() {
        setBackground(Color.red);
    }
}

class WorkPan extends JPanel {
    JPanel work = new JPanel();

    public WorkPan() {
        setBackground(Color.LIGHT_GRAY);
        setLayout(new BorderLayout(40, 50));
    }

    void TaskPannel() {
        System.out.println("here");
        add(new NewWork(), BorderLayout.CENTER);// adds NewWork panel

        // !!
        revalidate();
        repaint();
        // !!
    }
}

class MenuPan extends JPanel implements ActionListener {
    // !! WorkPan work = new WorkPan();
    WorkPan work; // !!
    JButton view; // !!

    // !!
    public MenuPan(WorkPan workPan) { // references are key

        // !!
        this.work = workPan; // set the reference!
        // !!

        setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        setLayout(new FlowLayout(1, 15, 10));
        view = new JButton(" Registered Courses ");
        view.addActionListener(this);
        add(view);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        work.TaskPannel();
    }
}

class userFrame extends JFrame {
    public void Frame() {
        setTitle("TEST CASE");
        setSize(900, 670);

        // !!
        WorkPan workPan = new WorkPan();
        MenuPan menuPan = new MenuPan(workPan);
        // !!

        // !!
        // add(new MenuPan(), BorderLayout.NORTH);
        // add(new WorkPan(), BorderLayout.CENTER);
        add(menuPan, BorderLayout.NORTH);
        add(workPan, BorderLayout.CENTER);
        // !!

        setLocationRelativeTo(this);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        userFrame u = new userFrame();
        u.Frame();
    }
}