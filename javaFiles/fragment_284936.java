import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class ImageList extends JPanel {
    private static final String BASE_PATH = "http://file.kelleybluebookimages.com/"
            + "kbb/images/content/editorial/";
    private static final String[] PATHS = {
        "2015-acura-tlx-guide-180.jpg",
        "13A420TFSI_01_hrgb-180.jpg",
        "CT_071713_BMW320i_0439-180.jpg",
        "2013-Cadillac-ATS-137-180.jpg",
        "EJ2V1342-180.jpg",
        "2014LexusIS005-180.jpg",
        "2014-volvo-s60-180.jpg",
        "2015-jeep-renegade-profile-180.jpg"
    };
    private DefaultListModel<Icon> listModel = new DefaultListModel<>();
    private JList<Icon> imageJList = new JList<>(listModel);

    public ImageList() throws IOException {
        for (String path : PATHS) {
            String imgPath = BASE_PATH + path;
            URL url = new URL(imgPath);
            BufferedImage img = ImageIO.read(url);
            listModel.addElement(new ImageIcon(img));
        }

        imageJList.setVisibleRowCount(4);
        JScrollPane scrollPane = new JScrollPane(imageJList);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        add(scrollPane);
    }    

    private static void createAndShowGui() {
        JFrame frame = new JFrame("ImageList");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            frame.getContentPane().add(new ImageList());
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        frame.pack();
        frame.setLocationRelativeTo(null);
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