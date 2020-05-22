import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;

public class Frame extends javax.swing.JFrame{

//Random varible
private Random rand = new Random();
//Array List to hold the file names and locations
private ArrayList<File> pictures;

//Class call
public Frame(){
    initComponents();
}

//Generates the gui. I Used netbeans to make this for me.                        
private void initComponents() {

    pictureLable1 = new javax.swing.JLabel();
    pictureLable2 = new javax.swing.JLabel();
    generateButton = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    generateButton.setText("Generate");
    generateButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            generateButtonActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(pictureLable1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(31, 31, 31)
            .addComponent(pictureLable2, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
            .addContainerGap())
        .addGroup(layout.createSequentialGroup()
            .addGap(151, 151, 151)
            .addComponent(generateButton)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(pictureLable2, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                .addComponent(pictureLable1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
            .addComponent(generateButton)
            .addContainerGap())
    );

    pack();
}                   

private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
    this.generate();
}                                              

/**
 * Generates the picture and then sets the labels accordingly.
 */
public void generate(){
    //Init the array list
    pictures = new ArrayList<>();

    //Add the pictures to the array list
    pictures.add(new File("C:/Users/UserName/Desktop/TestPictures/Picture1.png"));
    pictures.add(new File("banana.png"));
    pictures.add(new File("chocolate.png"));
    pictures.add(new File("icecream.png"));
    pictures.add(new File("bell.png"));
    pictures.add(new File("apple.png"));
    pictures.add(new File("money.png"));
    pictures.add(new File("number-7.png"));
    pictures.add(new File("necklace.png"));
    pictures.add(new File("gloves.png"));

    //Gets the random number for the picture
    int number = rand.nextInt((pictures.size() -1/*Max*/ - 0/*min*/) + 1) + 0/*Min*/;

    //Set the image icon to a randomly chosen image
    this.pictureLable1.setIcon(new ImageIcon(pictures.get(number).getAbsolutePath()));

    //Gets the random number again for the second picture
    number = rand.nextInt((pictures.size() -1/*Max*/ - 0/*min*/) + 1) + 0/*Min*/;

    //Set the second image icon to a randomly chosen image
    this.pictureLable1.setIcon(new ImageIcon(pictures.get(number).getAbsolutePath()));
}

/**
 * Your run of mill main method.
 *
 * @param args
 */
public static void main(String args[]){
    new Frame().setVisible(true);
}

// Variables declaration                
public javax.swing.JButton generateButton;
public static javax.swing.JLabel pictureLable1;
public static javax.swing.JLabel pictureLable2;

}