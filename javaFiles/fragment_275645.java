public class Main extends JFrame {

    public Main() {
        init();
    }

    public void init() {
        try {
            JSch jsch = new JSch();

            JPanel panel = new JPanel();
            panel.setPreferredSize(new Dimension(200, 200));
            JTextArea log = new JTextArea();
            JTextField cmd = new JTextField();
            panel.setLayout(new BorderLayout());
            JScrollPane scrollPane = new JScrollPane(log);
            panel.add(scrollPane, BorderLayout.CENTER);
            panel.add(cmd, BorderLayout.SOUTH);
            add(panel);

            Session session = jsch.getSession("akumar", "banas", 22);
            String passwd = "******";
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.setPassword(passwd);
            session.connect(30000);   // making a connection with timeout.

            Channel channel = session.openChannel("shell");
            channel.setInputStream(new CustomInputStream(cmd));
            channel.setOutputStream(new CustomOutputStream(log));
            channel.connect(3 * 1000);
            pack();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public class CustomInputStream extends InputStream implements ActionListener {

        final JTextField field;
        final BlockingQueue<String> q;

        public CustomInputStream(JTextField field) {
            this.field = field;
            q = new LinkedBlockingQueue<>();
            field.addActionListener(this);
        }

        private String s;
        int pos;

        @Override
        public int read() throws IOException {
            while (null == s || s.length() <= pos) {
                try {
                    s = q.take();
                    pos = 0;
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            int ret = (int) s.charAt(pos);
            pos++;
            return ret;
        }

        @Override
        public boolean markSupported() {
            return false;
        }

        @Override
        public int read(byte[] b, int off, int len) throws IOException {
            int bytes_copied = 0;
            while (bytes_copied < 1) {
                while (null == s || s.length() <= pos) {
                    try {
                        s = q.take();
                        System.out.println("s = " + s);
                        pos = 0;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                int bytes_to_copy = len < s.length()-pos ? len : s.length()-pos;
                System.arraycopy(s.getBytes(), pos, b, off, bytes_to_copy);
                pos += bytes_to_copy;
                bytes_copied += bytes_to_copy;
            }
            return bytes_copied;
        }

        @Override
        public int read(byte[] b) throws IOException {
            return read(b, 0, b.length); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            q.add(field.getText() + "\r\n");
            field.setText("");
        }

    }

// This is the code for making textarea as output stream
    public class CustomOutputStream extends OutputStream {

        private JTextArea textArea;

        public CustomOutputStream(JTextArea textArea) {
            this.textArea = textArea;
        }

        @Override
        public void write(int b) throws IOException {
            // redirects data to the text area
            textArea.append(String.valueOf((char) b));
            // scrolls the text area to the end of data
            textArea.setCaretPosition(textArea.getText().length());
        }

        @Override
        public void write(byte[] b, int off, int len) throws IOException {
            String s = new String(b,off,len);
            textArea.append(s);
            textArea.setCaretPosition(textArea.getText().length());
        }

        @Override
        public void write(byte[] b) throws IOException {
            this.write(b, 0, b.length);
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}