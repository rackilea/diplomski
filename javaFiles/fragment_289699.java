import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class ImagePaneTest extends JFrame
{
    ImageIcon       ic                  = new ImageIcon("./images/nice.jpg");
    JDesktopPane    dp                  = new JDesktopPane();
    JLabel          lbl                 = new JLabel(ic);
    JPanel          transparentPanel    = new JPanel();

    public ImagePaneTest()
    {

        lbl.setBounds(0, 0, 553, 421);

        dp.add(lbl, new Integer(50));
        dp.add(transparentPanel, new Integer(350));

        setLayeredPane(dp);

    }

    public static void main(String a[])
    {
        ImagePaneTest fr = new ImagePaneTest();
        Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
        fr.setIconImage(icon);

        fr.setSize(553, 421);
        fr.setVisible(true);
        fr.toFront();
        fr.setLocation(370, 200);
    }

}