import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.*;

public class Resistor extends JPanel {
    private String kod = "";
    private String kolor = "";
    private String pasek1 = "BLACK";
    private String pasek2 = "WHITE";
    private String pasek3 = "VIOLET";
    private String pasek4 = "WHITE";
    private String pasek5 = "BLACK";
    private String[] paseks = {pasek1, pasek2, pasek3, pasek4, pasek5};
    private JLabel imageLabel = new JLabel();
    private List<JComboBox<String>> combos = new ArrayList<>();
    private JTextField textField = new JTextField(10);

    public Resistor() {
        imageLabel.setIcon(createIcon());

        String[] pasek = { "BLACK", "BROWN", "RED", "ORANGE", "YELLOW", "GREEN", "BLUE", "VIOLET",
                "GRAY", "WHITE" };
        String[] multi = { "BLACK", "BROWN", "RED", "ORANGE", "YELLOW", "GREEN", "BLUE", "VIOLET" };
        String[] tol = { "BROWN", "RED", "GREEN", "BLUE", "VIOLET", "GRAY", "GOLD", "SILVER" };

        String[][] comboModels = {pasek, pasek, pasek, multi, tol};

        JPanel comboPanel = new JPanel(new GridLayout(2, 3));
        for (int i = 0; i < comboModels.length; i++) {
            JComboBox<String> combo = new JComboBox<>(comboModels[i]);
            combo.addActionListener(new ComboListener());
            comboPanel.add(combo);
            combos.add(combo);
        }
        comboPanel.add(textField);

        setLayout(new BorderLayout());
        add(imageLabel, BorderLayout.CENTER);
        add(comboPanel, BorderLayout.PAGE_END);
    }

    private Icon createIcon() {
        String[] pasek = { "BLACK", "BROWN", "RED", "ORANGE", "YELLOW", "GREEN", "BLUE", "VIOLET",
                "GRAY", "WHITE" };
        String[] multi = { "BLACK", "BROWN", "RED", "ORANGE", "YELLOW", "GREEN", "BLUE", "VIOLET" };
        String[] tol = { "BROWN", "RED", "GREEN", "BLUE", "VIOLET", "GRAY", "GOLD", "SILVER" };
        Map<String, Color> colors = new HashMap<String, Color>();
        colors.put("BLUE", Color.BLUE);
        colors.put("RED", Color.RED);
        colors.put("GREEN", Color.GREEN);
        colors.put("WHITE", Color.WHITE);
        colors.put("YELLOW", Color.YELLOW);
        colors.put("BLACK", Color.BLACK);
        colors.put("ORANGE", Color.ORANGE);
        colors.put("GRAY", Color.GRAY);
        colors.put("VIOLET", new Color(127, 0, 255));
        colors.put("BROWN", new Color(150, 75, 0));
        colors.put("GOLD", new Color(255, 215, 0));
        colors.put("SILVER", new Color(192, 192, 192));
        colors.put("LIGHT-BLUE", new Color(153, 204, 255));

        int w = 375;
        int h = 200;
        BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = img.createGraphics();

        int x = 100;
        g.setColor(colors.get("GRAY"));
        g.fillRect(40, 95, 60, 10);
        g.setColor(colors.get("GRAY"));
        g.fillRect(40, 95, 10, 50);

        g.setColor(colors.get("LIGHT-BLUE"));
        g.fillRect(x, 40, 20, 120);

        g.setColor(colors.get(pasek1));
        x = x + 20;
        g.fillRect(x, 40, 10, 120);

        g.setColor(colors.get("LIGHT-BLUE"));
        x = x + 10;
        g.fillRect(x, 40, 10, 120);

        g.setColor(colors.get("LIGHT-BLUE"));
        x = x + 10;
        g.fillRect(x, 50, 95, 100);

        g.setColor(colors.get(pasek2));
        x = x + 5;
        g.fillRect(x, 50, 10, 100);

        g.setColor(colors.get(pasek3));
        x = x + 30;
        g.fillRect(x, 50, 10, 100);

        g.setColor(colors.get(pasek4));
        x = x + 30;
        g.fillRect(x, 50, 10, 100);

        g.setColor(colors.get("LIGHT-BLUE"));
        x = x + 30;
        g.fillRect(x, 40, 10, 120);

        g.setColor(colors.get(pasek5));
        x = x + 10;
        g.fillRect(x, 40, 10, 120);

        g.setColor(colors.get("LIGHT-BLUE"));
        x = x + 10;
        g.fillRect(x, 40, 20, 120);

        g.setColor(colors.get("GRAY"));
        x = x + 20;
        g.fillRect(x, 95, 60, 10);
        x = x + 50;
        g.setColor(colors.get("GRAY"));
        g.fillRect(x, 95, 10, 50);

        g.dispose();
        return new ImageIcon(img);
    }

    private class ComboListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO finish!

        }
    }

    private static void createAndShowGui() {
        Resistor mainPanel = new Resistor();

        JFrame frame = new JFrame("Resistor");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}