import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.event.IIOReadProgressListener;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Client {

    public static void main(String[] args) {
        new Client();
    }

    public Client() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                final CapturePane capturePane = new CapturePane();

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(capturePane);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        try {
                            capturePane.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
                frame.setVisible(true);
            }
        });
    }

    public class CapturePane extends JPanel {

        private Socket socket;
        private ScreenPane screenPane;
        private JButton grabButton;

        public CapturePane() {
            setLayout(new BorderLayout());
            screenPane = new ScreenPane();
            grabButton = new JButton("Grab");
            try {
                socket = new Socket("localhost", 6789);
            } catch (IOException ex) {
                grabButton.setEnabled(false);
                ex.printStackTrace();
            }
            add(screenPane);
            add(grabButton, BorderLayout.SOUTH);

            grabButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (socket != null) {
                        InputStream is = null;
                        OutputStream os = null;

                        ByteArrayOutputStream baos = null;
                        ByteArrayInputStream bais = null;

                        try {
                            is = socket.getInputStream();
                            os = socket.getOutputStream();
                            // Send the "grab" request...
                            writeRequest(os, "grab");
                            System.out.println("Reading image...");
                            // Read back the expected byte size of the image
                            String size = readResponse(is);

                            int expectedByteCount = Integer.parseInt(size);
                            System.out.println("Expecting " + expectedByteCount);
                            // Create a buffer for the image bytes...
                            baos = new ByteArrayOutputStream(expectedByteCount);
                            byte[] buffer = new byte[1024];
                            int bytesRead = 0;
                            int bytesIn = 0;
                            // Read the image from the server...
                            while (bytesRead < expectedByteCount) {
                                bytesIn = is.read(buffer);
                                bytesRead += bytesIn;
                                baos.write(buffer, 0, bytesIn);
                            }
                            System.out.println("Read " + bytesRead);
                            baos.close();
                            // Wrap the result in an InputStream
                            bais = new ByteArrayInputStream(baos.toByteArray());

                            // Read the image...
                            BufferedImage image = ImageIO.read(bais);
                            System.out.println("Got image...");
                            screenPane.setImage(image);
                            bais.close();
                        } catch (IOException exp) {
                            exp.printStackTrace();
                        } finally {
                            try {
                                bais.close();
                            } catch (Exception exp) {
                            }
                            try {
                                baos.close();
                            } catch (Exception exp) {
                            }
                        }
                    }
                }

                protected String readResponse(InputStream is) throws IOException {
                    StringBuilder sb = new StringBuilder(128);
                    int in = -1;
                    while ((in = is.read()) != '\n') {
                        sb.append((char) in);
                    }
                    return sb.toString();
                }

            });
        }

        protected void writeRequest(OutputStream os, String request) throws IOException {
            os.write((request + "\n").getBytes());
            os.flush();
        }

        public void close() throws IOException {
            try {
                try {
                    System.out.println("Write done...");
                    writeRequest(socket.getOutputStream(), "shutdown");
                } finally {
                    try {
                        System.out.println("Close outputstream");
                        socket.getOutputStream().close();
                    } finally {
                        try {
                            System.out.println("Close inputStream");
                            socket.getInputStream().close();
                        } finally {
                            System.out.println("Close socket");
                            socket.close();
                        }
                    }
                }
            } finally {
                socket = null;
            }
        }

    }

    public class ScreenPane extends JPanel {

        private JLabel background;

        public ScreenPane() {
            setLayout(new BorderLayout());
            background = new JLabel();
            add(new JScrollPane(background));
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        public void setImage(BufferedImage img) {
            if (img != null) {
                ImageIcon icon = null;
                if (getWidth() > getHeight()) {
                    icon = new ImageIcon(img.getScaledInstance(getWidth(), -1, Image.SCALE_SMOOTH));
                } else {
                    icon = new ImageIcon(img.getScaledInstance(-1, getHeight(), Image.SCALE_SMOOTH));
                }
                background.setIcon(icon);
            } else {
                background.setIcon(null);
            }
            repaint();
        }

    }

}