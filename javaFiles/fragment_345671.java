import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ExampleApplet extends JApplet {

    private ExamplePanel examplePane;

    @Override
    public void init() {
        examplePane = new ExamplePanel();
        setLayout(new BorderLayout());
        add(examplePane);

        JButton check = new JButton("Check");
        add(check, BorderLayout.SOUTH);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                load();
            }
        });
    }

    public void load() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/databasea?user=root&password=root")) {
                try (PreparedStatement stmt = con.prepareStatement("Select * from tableB")) {
                    try (ResultSet rs = stmt.executeQuery()) {
                        while (rs.next()) {
                            String name = rs.getString(1);
                            examplePane.addName(name);
                            try (PreparedStatement delete = con.prepareStatement("delete from tableB where name = ?")) {
                                delete.setString(1, name);
                            } catch (SQLException exp) {
                                exp.printStackTrace();
                            }
                        }
                    } catch (SQLException exp) {
                        exp.printStackTrace();
                    }

                } catch (SQLException exp) {
                    exp.printStackTrace();
                }
            } catch (SQLException exp) {
                exp.printStackTrace();
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException exp) {
            exp.printStackTrace();
        }
    }

    public class ExamplePanel extends JPanel {

        private List<String> names;

        public ExamplePanel() {
            names = new ArrayList<>(25);
        }

        public void addName(String name) {
            names.add(name);
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            FontMetrics fm = g.getFontMetrics();
            int x = 0;
            int y = 0;
            for (String name : names) {

                String message = null;
                if (name.charAt(0) == '?') {
                    g.setColor(Color.GREEN);
                    g.fillOval(x, y, fm.getHeight(), fm.getHeight());
                    g.setColor(Color.WHITE);
                    message = name.substring(1) + " is in the table";
                } else {
                    g.setColor(Color.RED);
                    g.fillOval(x, y, fm.getHeight(), fm.getHeight());
                    g.setColor(Color.BLACK);
                    message = name.substring(1) + " is not in the table";
                }
                g.drawString(message, fm.getHeight(), y);
                y += fm.getHeight();
            }
        }

    }

}