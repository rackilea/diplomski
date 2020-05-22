import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.ArrayList;

public class PurchaseStock  extends JFrame implements ActionListener {
    private JComboBox stockOptions = new JComboBox();
    private JLabel imgDis;
    private List<String> filename = new ArrayList<String>();
    StockData sD;

    PurchaseStock () {
        super("Fist Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel top = new JPanel();
        add("North", top);
        JPanel middle = new JPanel();
        add("Center", middle);

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
                                middle.remove(imgDis);
                                imgDis = new JLabel(setImageSize(filePath));
                                middle.add(imgDis);
                                middle.repaint();
                                middle.revalidate();
                            }
                        }
                    }
                }
            }
        );

        top.add(stockOptions);



        imgDis = new JLabel(setImageSize("images/crazyEmoji.jpg"));
        imgDis.setPreferredSize(new Dimension(200,200));
        middle.add(imgDis);

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

    @Override
    public void actionPerformed(ActionEvent ae) {

    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PurchaseStock  frame = new PurchaseStock ();
            }
        });
    }
}