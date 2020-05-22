public class ConsoleInFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConsoleInFrame().showGui();
            }
        });
    }

    public void showGui() {
        JFrame frame = new JFrame();
        JTextField file = new JTextField(20);
        JTextField aText = new JTextField(4);
        JTextField bText = new JTextField(4);
        JButton go = new JButton("Go");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(new JLabel("File"));
        panel.add(file);
        panel.add(new JLabel("a"));
        panel.add(aText);
        panel.add(new JLabel("b"));
        panel.add(bText);

        frame.getContentPane().setLayout(
                new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.getContentPane().add(panel);

        frame.getContentPane().add(go);

        go.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                process(file.getText(), Integer.parseInt(aText.getText()),
                        Integer.parseInt(bText.getText()));
            }
        });
        frame.pack();
        frame.setVisible(true);
    }

    public void process(String name, int a, int b) {
        String fileName = new SimpleDateFormat("dd-MM-yyyy_HH-mm'.txt'")
                .format(new Date());
        String obs;
        String path = "some path";
        int c = 0, d = 0;
        if (a >= 100) {
            d = a / 100;
            c = a % 100;
            b = c;
            a = a + d;
        }
        File file;
        if (StringUtils.isBlank(name)) {
            file = new File(path + fileName);
        } else {
            file = new File(path + name + "#" + fileName);
        }

        FileWriter writer = null;
        try {
            writer = new FileWriter(file);
            writer.write("something");

            if (StringUtils.isBlank(obs)) {
                writer.write("something");
            } else {
                writer.write(obs + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null)
                try {
                    writer.close();
                } catch (IOException ignore) {
                }
        }

    }
}