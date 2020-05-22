import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.List;
import java.util.ArrayList;

public class StockDropdown extends JFrame {
    private JComboBox stockOptions = new JComboBox();
    private JLabel imgDis;
    private List<String> filename = new ArrayList<String>();
    StockData sD;

    StockDropdown() {
        super("Fist Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();

        for(String key : sD.getStock().keySet())  {
          stockOptions.addItem(sD.getName(key));
          filename.add(sD.getFilename(key));
        }

        stockOptions.addItemListener(
            new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent ie) {
                    if(ie.getStateChange() == ItemEvent.SELECTED){
                        String temp = stockOptions.getSelectedItem().toString();
                        String filePath;

                        for(String key : sD.getStock().keySet())  {
                            if(temp.equals(sD.getName(key))) {
                                filePath = sD.getFilename(key);
                                remove(imgDis);
                                imgDis = new JLabel(setImageSize(filePath));
                                c.gridy = 1;
                                add(imgDis,c);
                                repaint();
                                revalidate();
                            }
                        }
                    }
                }
            }
        );
        c.gridy = 0;
        add(stockOptions,c);


        imgDis = new JLabel(setImageSize("images/crazyEmoji.jpg"));
        c.gridy = 1;
        imgDis.setPreferredSize(new Dimension(200,200));
        add(imgDis,c);

        pack();
        setVisible(true);
    }

    private ImageIcon setImageSize(String path) {
        ImageIcon image1 = new ImageIcon(path);
        Image image2 = image1.getImage().getScaledInstance(200,200,0);
        return new ImageIcon(image2);
    };

    public JComboBox getComboBox(){
        return stockOptions;
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                StockDropdown frame = new StockDropdown();
            }
        });
    }
}