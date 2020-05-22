enter code here

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author JAY
 */
public class HomePageOfApp {

    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton aboutUsBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton powerBtn;
    private javax.swing.JButton presetBtn;
    private javax.swing.JButton settingBtn;
    static JInternalFrame internalFrame = null;
    private static final GridBagConstraints gbc;

    static {
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHWEST;
    }

    public HomePageOfApp() {
        initComponents();
        internalFrame = new JInternalFrame("Home Page", false, false, true, false);
        internalFrame.setBounds(0, 0, 784, 434);
        internalFrame.setLocation(0, 0);
        internalFrame.setContentPane(wrapInBackgroundImage(jPanel1,
                new ImageIcon(
                getClass().getResource("/myImage1.jpg"))));
        internalFrame.setVisible(true);
    }

    private void initComponents() {
java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        powerBtn = new javax.swing.JButton();
        presetBtn = new javax.swing.JButton();
        aboutUsBtn = new javax.swing.JButton();
        settingBtn = new javax.swing.JButton();


        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        powerBtn.setIcon(new javax.swing.ImageIcon("E:\\Image2_60.png")); // NOI18N
        powerBtn.setBorderPainted(false);
        powerBtn.setContentAreaFilled(false);
        powerBtn.setFocusPainted(false);
        powerBtn.setPressedIcon(new javax.swing.ImageIcon("E:\\Image2_50.png")); // NOI18N
        powerBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                powerBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -31;
        gridBagConstraints.ipady = -8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(106, 27, 0, 0);
        jPanel1.add(powerBtn, gridBagConstraints);

        presetBtn.setIcon(new javax.swing.ImageIcon("E:\\Image2_60.png")); // NOI18N
        presetBtn.setBorderPainted(false);
        presetBtn.setContentAreaFilled(false);
        presetBtn.setFocusPainted(false);
        presetBtn.setPressedIcon(new javax.swing.ImageIcon("E:\\Image2_50.png")); // NOI18N
        presetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                presetBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -31;
        gridBagConstraints.ipady = -8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(106, 26, 0, 19);
        jPanel1.add(presetBtn, gridBagConstraints);

        aboutUsBtn.setIcon(new javax.swing.ImageIcon("E:\\Image2_60.png")); // NOI18N
        aboutUsBtn.setBorderPainted(false);
        aboutUsBtn.setContentAreaFilled(false);
        aboutUsBtn.setFocusPainted(false);
        aboutUsBtn.setPressedIcon(new javax.swing.ImageIcon("E:\\Image2_50.png")); // NOI18N
        aboutUsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutUsBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = -31;
        gridBagConstraints.ipady = -8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(42, 57, 32, 0);
        jPanel1.add(aboutUsBtn, gridBagConstraints);

        settingBtn.setIcon(new javax.swing.ImageIcon("E:\\Image2_60.png")); // NOI18N
        settingBtn.setBorderPainted(false);
        settingBtn.setContentAreaFilled(false);
        settingBtn.setFocusPainted(false);
        settingBtn.setPressedIcon(new javax.swing.ImageIcon("E:\\Image2_50.png")); // NOI18N
        settingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = -31;
        gridBagConstraints.ipady = -8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(42, 27, 32, 0);
        jPanel1.add(settingBtn, gridBagConstraints);

    }

    private void powerBtnActionPerformed(java.awt.event.ActionEvent evt) {
// TODO add your handling code here:
    }

    private void presetBtnActionPerformed(java.awt.event.ActionEvent evt) {
// TODO add your handling code here:
    }

    private void aboutUsBtnActionPerformed(java.awt.event.ActionEvent evt) {
// TODO add your handling code here:
    }

    private void settingBtnActionPerformed(java.awt.event.ActionEvent evt) {
// TODO add your handling code here:
    }

    /**
     * Wraps a Swing JComponent in a background image. Simply invokes the overloded
     * variant with Top/Leading alignment for background image.
     *
     * @param component - to wrap in the a background image
     * @param backgroundIcon - the background image (Icon)
     * @return the wrapping JPanel
     */
    public static JPanel wrapInBackgroundImage(JComponent component,
            Icon backgroundIcon) {
        return wrapInBackgroundImage(
                component,
                backgroundIcon,
                JLabel.TOP,
                JLabel.CENTER);
    }

    /**
     * Wraps a Swing JComponent in a background image. The vertical and horizontal
     * alignment of background image can be specified using the alignment
     * contants from JLabel.
     *
     * @param component - to wrap in the a background image
     * @param backgroundIcon - the background image (Icon)
     * @param verticalAlignment - vertical alignment. See contants in JLabel.
     * @param horizontalAlignment - horizontal alignment. See contants in JLabel.
     * @return the wrapping JPanel
     */
    public static JPanel wrapInBackgroundImage(JComponent component,
            Icon backgroundIcon,
            int verticalAlignment,
            int horizontalAlignment) {

        // make the passed in swing component transparent
        component.setOpaque(false);

        // create wrapper JPanel
        JPanel backgroundPanel = new JPanel(new GridBagLayout());
        backgroundPanel.setBackground(new java.awt.Color(255, 255, 255));

        // add the passed in swing component first to ensure that it is in front
        backgroundPanel.add(component, gbc);

        // create a label to paint the background image
        JLabel backgroundImage = new JLabel(backgroundIcon);

        // set minimum and preferred sizes so that the size of the image
        // does not affect the layout size
        backgroundImage.setPreferredSize(new Dimension(1, 1));
        backgroundImage.setMinimumSize(new Dimension(1, 1));

        // align the image as specified.
        backgroundImage.setVerticalAlignment(verticalAlignment);
        backgroundImage.setHorizontalAlignment(horizontalAlignment);

        // add the background label
        backgroundPanel.add(backgroundImage, gbc);

        // return the wrapper
        return backgroundPanel;
    }
}