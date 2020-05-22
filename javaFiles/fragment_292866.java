import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadingExample {

    public static void main(String[] args) {

        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JTextArea jTextArea = new JTextArea();

        JScrollPane scrollPane = new JScrollPane(jTextArea);
        scrollPane.setPreferredSize(new Dimension(300, 300));
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JButton btnNewButton = new JButton("Start Reading");
        mainPanel.add(btnNewButton, BorderLayout.SOUTH);

        jFrame.setContentPane(mainPanel);

        jFrame.pack();
        jFrame.setVisible(true);

        btnNewButton.addActionListener(e -> {

            new Thread(() -> {

                File file = new File("file.txt");

                try (FileReader fileReader = new FileReader(file);
                     BufferedReader bufferedReader = new BufferedReader(fileReader)) {

                    String line;
                    while((line = bufferedReader.readLine()) != null) {

                        final String fLine = line;

                        SwingUtilities.invokeLater(() -> {
                            jTextArea.append(fLine + "\n");
                            jTextArea.setCaretPosition(jTextArea.getDocument().getLength());
                        });

                        Thread.sleep(200);
                    }

                } catch (Exception e1) {
                    e1.printStackTrace();
                }

            }).start();
        });
    }
}