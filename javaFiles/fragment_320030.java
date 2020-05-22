import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.image.*;
import javax.imageio.ImageIO;

public class Picture{
    JFileChooser fileChooser = new JFileChooser();
    final JFrame frame = new JFrame("Edit Image");
    Container content;
    static BufferedImage image;
    BufferedImage image2;
    JLabel imageLabel;

    public Picture() {
        //asks for image file as input
        fileChooser.setDialogTitle("Choose an image file to begin:");
        fileChooser.showOpenDialog(frame);
        File selectedFile = fileChooser.getSelectedFile();
        if (fileChooser.getSelectedFile() != null) {
            try {
                //reads File as image
                image = ImageIO.read(selectedFile);
            }
            catch (IOException e) {
                System.out.println("Invalid image file: " + selectedFile);
                System.exit(0);
            }
        }
        else {
            System.out.println("No File Selected!");
        }
    }

    public int width() {
        //returns width of present image
        int width = image.getWidth();
        return width;
    }

    public int height() {
        //returns height of present image
        int height = image.getHeight();
        return height;
    }
/*
    public void getImage() {
        this.image2 = image;
    }
*/
    public void saveImage() {
        //saves current image as JPEG
        fileChooser.setDialogTitle("Save this image?");
        fileChooser.showSaveDialog(frame);
        try {
            //writes new file
            ImageIO.write(this.image, "JPG", fileChooser.getSelectedFile());
        }
        catch (IOException f) {
            System.out.println("Saving failed! Could not save image.");
        }
    }

    public void show() {
        //set frame title, set it visible, etc
        content = frame.getContentPane();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        //add the image to the frame
        ImageIcon icon = new ImageIcon(image);
        imageLabel = new JLabel(icon);
        frame.setContentPane(imageLabel);

        //add a menubar on the frame with a single option: saving the image
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu progName = new JMenu("Edit Image");
        progName.setBackground(Color.RED);
        menuBar.add(progName);
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        JMenu editMenu = new JMenu("Edit");
        menuBar.add(editMenu);

        ImageIcon exitIcon = new ImageIcon("app-exit.png");
        JMenuItem exitAction = new JMenuItem("Exit", exitIcon);
        progName.add(exitAction);
        exitAction.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ImageIcon saveIcon = new ImageIcon("save-icon.png");
                    int askSave = JOptionPane.showConfirmDialog(null,"Save current image?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, saveIcon);
                    if (askSave == JOptionPane.YES_OPTION) {
                        //opens save image method, then exits
                        saveImage();
                        System.exit(0);
                    }
                    else {
                        //exits without saving
                        System.exit(0);
                    }
                }
            });

        ImageIcon newIcon = new ImageIcon("new-image.png");
        JMenuItem newAction = new JMenuItem("Open Image", newIcon);
        fileMenu.add(newAction);
        newAction.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ImageIcon saveIcon = new ImageIcon("save-icon.png");
                    int askSave = JOptionPane.showConfirmDialog(null,"Save current image?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, saveIcon);
                    if (askSave == JOptionPane.YES_OPTION) {
                        //opens save image method, then asks asks for new image file
                        saveImage();
                        Picture p = new Picture();
                        imageLabel.setIcon(new ImageIcon(image));
                        //resizes canvas to fit new image
                        frame.setSize(width(), height());
                    }
                    else {
                        //asks for new image file since user did not want to save original
                        Picture p = new Picture();
                        imageLabel.setIcon(new ImageIcon(image));
                        //resizes canvas to fit new image
                        frame.setSize(width(), height());
                    }
                }
            });

        ImageIcon saveIcon = new ImageIcon("save-image.png");
        JMenuItem saveAction = new JMenuItem("Save Image As...", saveIcon);
        fileMenu.add(saveAction);
        saveAction.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //opens save image method
                    saveImage();
                }
            });
        ImageIcon gsIcon = new ImageIcon("grayscale-image.png");
        JMenuItem grayScale = new JMenuItem("Grayscale", gsIcon);
        editMenu.add(grayScale);
        grayScale.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //grabs height and width of image, then grayscales it
                    grayscale(width(), height());
                }
            });

        ImageIcon scaleIcon = new ImageIcon("scale-image.png");
        JMenuItem scaleImg = new JMenuItem("Scale Image", scaleIcon);
        editMenu.add(scaleImg);
        scaleImg.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //asks for height and width to create new image
                    ImageIcon widthIcon = new ImageIcon("LR-arrows.png");
                    String scaleWidth = (String)JOptionPane.showInputDialog(null,"What should the new width be?", "", JOptionPane.QUESTION_MESSAGE, widthIcon, null, null);
                    ImageIcon heightIcon = new ImageIcon("UD-arrows.png");
                    String scaleHeight = (String)JOptionPane.showInputDialog(null,"What should the new height be?", "", JOptionPane.QUESTION_MESSAGE, widthIcon, null, null);
                    //turns user input strings into doubles
                    double x = Double.parseDouble(scaleWidth);
                    double y = Double.parseDouble(scaleHeight);
                    //casts doubles as ints
                    int newWidth = (int)x;
                    int newHeight = (int)y;
                    //resizes frame to fit new image dimensions
                    frame.setSize(newWidth, newHeight);
                    //calls scale method to resize image using given dimensions
                    scale(newWidth, newHeight);
                }
            });
        ImageIcon rotateIcon = new ImageIcon("rotate-image.png");
        JMenuItem rotateImg = new JMenuItem("Rotate Image", rotateIcon);
        editMenu.add(rotateImg);
        rotateImg.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                }
            });

        //paint the frame
        frame.pack();
        frame.repaint();
        frame.setVisible(true);
    }

    // convert to grayscale
    public void grayscale(int width, int height) {
        // create a grayscale image with original dimensions
        image2 = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);

        // convert colored image to grayscale
        ColorConvertOp grayScale = new ColorConvertOp(image.getColorModel().getColorSpace(),image2.getColorModel().getColorSpace(),null);
        grayScale.filter(image,image2);
        imageLabel.setIcon(new ImageIcon(image2));
        //getImage();
        image = image2;
    }

    //scales image by a given factor
    public void scale(int width, int height){
        //uses user-input dimensions to create new image
        image2 = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image2.createGraphics();
        //gets new dimensions and resizes image
        g.drawImage(image, 0, 0, image2.getWidth(), image2.getHeight(), 0, 0, width(), height(), null);
        imageLabel.setIcon(new ImageIcon(image2));
        //getImage();
        image = image2;
    }

    //rotates the image
    public void rotate(int width, int height, int theta) {

    }

    public static void main(String[] args) {
        Picture p = new Picture();
        p.show();
    }
}