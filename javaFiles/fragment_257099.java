package twoBalls;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Display implements Runnable {

    private GUIModel guiModel;

    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Display());
    }

    public Display() {
        this.guiModel = new GUIModel();
        Ball ball1 = new Ball(150, 200, 50, Color.BLUE);
        Ball ball2 = new Ball(450, 200, 50, Color.GREEN);
        guiModel.addBall(ball1);
        guiModel.addBall(ball2);
        guiModel.calculatePoints();
    }

    @Override
    public void run() {
        frame = new JFrame();
        frame.setTitle("Show Balls Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        DrawingPanel drawingPanel = new DrawingPanel(guiModel);
        panel.add(drawingPanel, BorderLayout.CENTER);

        panel.add(createButtonPanel(drawingPanel), BorderLayout.SOUTH);

        frame.add(panel);

        frame.pack();
        frame.setVisible(true);
    }

    private JPanel createButtonPanel(DrawingPanel drawingPanel) {
        JPanel panel = new JPanel();

        JButton startButton = new JButton("Start Animation");
        startButton.addActionListener(new StartAnimation(drawingPanel));
        panel.add(startButton);

        return panel;
    }

    public class StartAnimation implements ActionListener {

        private DrawingPanel drawingPanel;

        public StartAnimation(DrawingPanel drawingPanel) {
            this.drawingPanel = drawingPanel;
        }

        @Override
        public void actionPerformed(ActionEvent event) {
            LineRunnable runnable = new LineRunnable(drawingPanel);
            new Thread(runnable).start();
        }

    }

}