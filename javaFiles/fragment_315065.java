import java.awt.*;
import javax.swing.*;

public class WindowApplication extends JFrame {
    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;

    protected static JLabel redLabel;
    protected static JLabel greenLabel;
    protected static JLabel blueLabel;

    protected static JTextField redTextField;
    protected static JTextField greenTextField;
    protected static JTextField blueTextField;

    protected static JButton redButtonM;
    protected static JButton greenButtonM;
    protected static JButton blueButtonM;

    protected static JButton redButtonP;
    protected static JButton greenButtonP;
    protected static JButton blueButtonP;

    protected static JButton saveButton;
    protected static JButton resetButton;

    protected static JList listColors;

    protected static DrawingTester drawTest;



    public static void addComponentsToPane(Container pane) 
    {
        if (RIGHT_TO_LEFT) {
            pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }


        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        if (shouldFill) {
        //natural height, maximum width
        c.fill = GridBagConstraints.HORIZONTAL;
        }


        /**
         * Setup the RGB Labels
         * 
         * R <0,1>
         * G <0,2>
         * B <0,3>
         * 
         */

//        c.insets = new Insets(0,10,0,5);

        c.gridwidth = 1;
        redLabel = new JLabel("Red:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        pane.add(redLabel, c);

        greenLabel = new JLabel("Green:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        pane.add(greenLabel, c);

        blueLabel = new JLabel("Blue:");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 3;
        pane.add(blueLabel, c);

        /**
         * Setup the RGB Text Fields
         * 
         * R<1,1>
         * G<1,2>
         * B<1,3>
         * 
         */


//        c.insets.set(0, 0, 0, 5);

        redTextField = new JTextField("255");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        pane.add(redTextField, c);

        greenTextField = new JTextField("0");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        pane.add(greenTextField, c);

        blueTextField = new JTextField("0");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 3;
        pane.add(blueTextField, c);

        /**
         * Setup the RGB (-) Button Fields
         * 
         * R<2,1>
         * G<2,2>
         * B<2,3>
         * 
         */

//        c.insets.set(5,5,0,10);

        redButtonM = new JButton("-");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 1;
        pane.add(redButtonM, c);

        greenButtonM = new JButton("-");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 2;
        pane.add(greenButtonM, c);

        blueButtonM = new JButton("-");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 3;
        pane.add(blueButtonM, c);

        /**
         * Setup the RGB (+) Button Fields
         * 
         * R<3,1>
         * G<3,2>
         * B<3,3>
         * 
         */

//        c.insets.set(5,0,0,10);

        redButtonP = new JButton("+");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 1;
        pane.add(redButtonP, c);

        greenButtonP = new JButton("+");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 2;
        pane.add(greenButtonP, c);

        blueButtonP = new JButton("+");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 3;
        pane.add(blueButtonP, c);

        /**
         * Setup the Save/Reset Buttons
         * 
         * save <0,4>
         * reset<1,4>
         * 
         */

        saveButton = new JButton("Save");
        c.insets.set(10,10,10,5);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;      //make this component tall
        c.ipadx = 10;
        //c.weightx = 0.0;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 4;
        pane.add(saveButton, c);


        resetButton = new JButton("Reset");
        c.insets.set(10,5,10,10);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 10;      
        c.ipadx = 10;
        //c.weighty = 1.0;   //request any extra vertical space
        //c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.gridx = 2;       //aligned with button 2
        c.gridwidth = 2;   //2 columns wide
        c.gridy = 4;       //third row
        pane.add(resetButton, c);

        /**
         * Setup the Color Selection List
         * 
         * <4,0>
         * 
         */

        c.insets.set(5,5,5,5);

        listColors = new JList(new Object[] {"Test 1", "Test 2", "Test 3"});
        /**
            File reading shenanigans to fill up the list
        */
        c.fill = GridBagConstraints.BOTH;
        c.gridy = 0;       
        c.gridx = 4;       
        c.gridheight = 5;   
        c.gridwidth = 1;

        pane.add(listColors, c);

        /**
         * Setup the Graphics
         * 
         * <0,0>
         * 
         */

        drawTest = new DrawingTester();
        c.insets = new Insets(5,5,5,5);
        c.fill = GridBagConstraints.BOTH;
        c.gridx = 0;       //top leftw
        c.gridy = 0;       //bottom
        c.gridheight = 1;
        c.gridwidth = 4;
        pane.add(drawTest,c);
    }


    public static void main (String argv[])
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI("Color Sampler");
            }
        });
    }

    public static void createAndShowGUI(String title)
    {
        // Create and setup the window
        JFrame frame = new JFrame (title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setup the content pane
        addComponentsToPane(frame.getContentPane());

        // Display the window
        frame.pack();
        frame.setVisible(true);

    }


}

class DrawingTester extends JComponent {

  public void paintComponent(Graphics g){
      super.paintComponent(g);
      g.setColor(Color.red);
      g.fillRect(0,0, g.getClipBounds().width, g.getClipBounds().height);   
  }
}