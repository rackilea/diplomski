import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.List;
import java.util.ArrayList;

public class StockDropdown extends JComboBox {
    List<String> filename = new ArrayList<String>();

    private JLabel imgDis;
    StockData sD;
    PurchaseStock pS;


    public StockDropdown(PurchaseStock pS) {
        this.pS = pS;

        imgDis = new JLabel(setImageSize("images/crazyEmoji.jpg"));
        imgDis.setPreferredSize(new Dimension(200,200));
        pS.getMiddle().add(imgDis);
        pS.getMiddle().repaint();
        pS.getMiddle().revalidate();

        for(String key : sD.getStock().keySet())  {
          addItem(sD.getName(key));
        }

        addItemListener(
            new ItemListener() {
               @Override
                public void itemStateChanged(ItemEvent ie) {
                    if(ie.getStateChange() == ItemEvent.SELECTED){
                        String temp = getSelectedItem().toString();
                        String filePath;

                        for(String key : sD.getStock().keySet())  {
                            if(temp.equals(sD.getName(key))) {
                                filePath = sD.getFilename(key);
                                pS.getMiddle().remove(imgDis);
                                imgDis = new JLabel(setImageSize(filePath));
                                pS.getMiddle().add(imgDis);
                                pS.getMiddle().repaint();
                                pS.getMiddle().revalidate();
                            }
                        }
                    }
                }
            }
        );
    }

    private ImageIcon setImageSize(String path) {
        ImageIcon image1 = new ImageIcon(path);
        Image image2 = image1.getImage().getScaledInstance(200,200,0);
        return new ImageIcon(image2);
    };
}