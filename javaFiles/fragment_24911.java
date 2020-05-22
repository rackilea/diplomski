import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class ImageShuffle extends JPanel {
    private static final int SIDES = 3;
    public static final String IMG_PATH = "https://upload.wikimedia.org/wikipedia/commons/"
            + "thumb/5/5a/Hurricane_Kiko_Sep_3_1983_1915Z.jpg/"
            + "600px-Hurricane_Kiko_Sep_3_1983_1915Z.jpg";
    private List<Icon> iconList = new ArrayList<>(); // shuffled icons
    private List<Icon> solutionList = new ArrayList<>();  // in order
    private List<JLabel> labelList = new ArrayList<>();  // holds JLabel grid
    private Icon blankIcon;

    public ImageShuffle(BufferedImage img) {
        setLayout(new GridLayout(SIDES, SIDES, 1, 1));
        fillIconList(img); // fill array list with icons and one blank one
        Collections.shuffle(iconList); 
        MyMouseListener myMouse = new MyMouseListener();
        for (Icon icon : iconList) {
            JLabel label = new JLabel(icon);
            label.addMouseListener(myMouse);
            add(label);
            labelList.add(label);
        }
    }

    private class MyMouseListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            JLabel selectedLabel = (JLabel) e.getSource();
            if (selectedLabel.getIcon() == blankIcon) {
                return; // don't want to move the blank icon
            }
            // index variables to hold selected and blank JLabel's index location
            int selectedIndex = -1;
            int blankIndex = -1;
            for (int i = 0; i < labelList.size(); i++) {
                if (selectedLabel == labelList.get(i)) {
                    selectedIndex = i;                    
                } else if (labelList.get(i).getIcon() == blankIcon) {
                    blankIndex = i;
                }
            }

            // get row and column of selected JLabel
            int row = selectedIndex / SIDES;
            int col = selectedIndex % SIDES;

            // get row and column of blank JLabel
            int blankRow = blankIndex / SIDES;
            int blankCol = blankIndex % SIDES;

            if (isMoveValid(row, col, blankRow, blankCol)) {
                Icon selectedIcon = selectedLabel.getIcon();
                labelList.get(selectedIndex).setIcon(blankIcon);
                labelList.get(blankIndex).setIcon(selectedIcon);

                // test for win here by comparing icons held by labelList
                // with the solutionList
            } 
        }

        private boolean isMoveValid(int row, int col, int blankRow, int blankCol) {
            // has to be on either same row or same column
            if (row != blankRow && col != blankCol) {
                return false;
            }
            // if same row
            if (row == blankRow) {
                // then columns must be off by 1 -- they're next to each other
                return Math.abs(col - blankCol) == 1;
            } else {
                // or else rows off by 1 -- above or below each other
                return Math.abs(row - blankRow) == 1;
            }
        }

        public void shuffle() {
            Collections.shuffle(iconList);
            for (int i = 0; i < labelList.size(); i++) {
                labelList.get(i).setIcon(iconList.get(i));
            }
        }
    }

    private void fillIconList(BufferedImage img) {
        // get the width and height of each individual icon
        // which is 1/3 the image width and height
        int w = img.getWidth() / SIDES;
        int h = img.getHeight() / SIDES;
        for (int row = 0; row < SIDES; row++) {
            int y = (row * img.getWidth()) / SIDES;
            for (int col = 0; col < SIDES; col++) {
                int x = (col * img.getHeight()) / SIDES;
                // create a sub image
                BufferedImage subImg = img.getSubimage(x, y, w, h);
                // create icon from the image
                Icon icon = new ImageIcon(subImg);
                // add to both icon lists
                iconList.add(icon);
                solutionList.add(icon);
            }
        }

        // create a blank image and corresponding icon as well.
        BufferedImage blankImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        blankIcon = new ImageIcon(blankImg);
        iconList.remove(iconList.size() - 1);  // remove last icon from list
        iconList.add(blankIcon);   // and swap in the blank one
        solutionList.remove(iconList.size() - 1);  // same for the solution list
        solutionList.add(blankIcon);
    }


    private static void createAndShowGui(BufferedImage img) {
        JFrame frame = new JFrame("ImageShuffle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new ImageShuffle(img));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        URL imgUrl = null;
        BufferedImage img;
        try {
            imgUrl = new URL(IMG_PATH);
            img = ImageIO.read(imgUrl);
            SwingUtilities.invokeLater(() -> createAndShowGui(img));
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }
}