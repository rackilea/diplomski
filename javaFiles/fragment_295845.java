import javax.swing.*;
import java.awt.*;

public class Admin_hs extends JFrame {
    JButton bking_btn= new JButton("Bookings");
    JButton fd_btn= new JButton("Financial Data");
    JButton ctm_btn= new JButton("Customers");
    JButton room_btn= new JButton("Rooms");
    JButton adc_btn= new JButton("Additional Costs");
    JButton endb_btn= new JButton("Ending Bookings");

    //Images
    JLabel bking_img= new JLabel();
    JLabel fd_img= new JLabel();
    JLabel ctm_img= new JLabel();
    JLabel room_img= new JLabel();
    JLabel adc_img= new JLabel();
    JLabel endb_img= new JLabel();
    JLabel copyrightL = new JLabel("Hotel Management System \u00a9 2016");

    ///Panels

    JPanel pnl1 = new JPanel(new GridBagLayout()), pnl2 = new JPanel(new GridBagLayout());

    ///Constructors

    public Admin_hs(){
        setTitle("Welcome Admin!");
        setLayout(new GridBagLayout());

        ///Setting a layout

        pnl1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill= GridBagConstraints.HORIZONTAL;

        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;

        pnl1.add(bking_btn, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        pnl1.add(fd_btn, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        pnl1.add(ctm_btn, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        pnl1.add(room_btn, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        pnl1.add(adc_btn, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        pnl1.add(endb_btn, gbc);


        /////second column of grid
        gbc.weightx = 0;
        gbc.fill= GridBagConstraints.BOTH;

        ImageIcon icon = new ImageIcon("Smiley.gif");
        Image image2 = icon.getImage().getScaledInstance(50, 50, 0);
        ImageIcon icon2 = new ImageIcon(image2);

        gbc.gridx = 1;
        gbc.gridy = 0;
        bking_img.setIcon(icon2);
        pnl1.add(bking_img, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        fd_img.setIcon(icon2);
        pnl1.add(fd_img, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        ctm_img.setIcon(icon2);
        pnl1.add(ctm_img, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        room_img.setIcon(icon2);
        pnl1.add(room_img, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        adc_img.setIcon(icon2);
        pnl1.add(adc_img, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        endb_img.setIcon(icon2);
        pnl1.add(endb_img, gbc);

        pnl1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));

        gbc.insets = new Insets(0, 0, 0, 0);

        gbc.gridwidth = 1;
        gbc.weightx = 1.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(pnl1, gbc);

        gbc.fill= GridBagConstraints.HORIZONTAL;

        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        pnl2.add(copyrightL, gbc);

        gbc.weightx = 0;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(pnl2, gbc);
    }
}