import java.awt.*;
import javax.swing.*;

public class SolverUserInterface {

    private JFrame solverUI;
    private JPanel panel;
    private JLabel lbl[];
    private JTextField eq_Fields[];

    public SolverUserInterface(int Count) {
        solverUI = new JFrame("Solver");
        solverUI.setLocationByPlatform(true);
        solverUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel = new JPanel(new BorderLayout());
        JPanel labels = new JPanel(new GridLayout(0,1,5,5));
        JPanel fields = new JPanel(new GridLayout(0,1,5,5));
        lbl = new JLabel[Count];
        panel.add(labels, BorderLayout.LINE_START);
        panel.add(fields, BorderLayout.CENTER);
        eq_Fields = new JTextField[Count];
        for(int i = 0; i < Count; i++){
            lbl[i] = new JLabel("Equation "+(i+1)+" : ");
            eq_Fields[i] = new JTextField(26);
            labels.add(lbl[i]);
            fields.add(eq_Fields[i]);
        }
        JButton btnSolve = new JButton("Solve Equations!");
        solverUI.add(btnSolve, BorderLayout.PAGE_END);

        JScrollPane jp = new JScrollPane(
            panel,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        solverUI.add(jp);

        solverUI.pack();
        Dimension d = solverUI.getSize();
        int w = (int)d.getWidth();
        int h = (int)d.getHeight();
        h = (h>200 ? 200 : h);
        Dimension shrinkHeight = new Dimension(w,h);
        solverUI.setSize(shrinkHeight);
    }

    public void showUserInterface(){
        solverUI.setVisible(true);
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                SolverUserInterface sui = new SolverUserInterface(105);
                sui.showUserInterface();
            }
        };
        SwingUtilities.invokeLater(r);
    }
}