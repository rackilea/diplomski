import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class Main extends JFrame implements ActionListener {
    private int[] intArray = new int[10000];
    private int numOfInts = 0;
    private int avg = 0;

    protected JButton avgBtn;
    protected JTextField indexEntry;
    protected JLabel instructions;
    protected JPanel resultsPanel;

    //constructor - construct the components here and do the initializations
    public Main(){
        //create main frame     
        this.setTitle("Section V, question 2");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350, 250);
        this.setLayout(new GridLayout(4, 1));
        //this.setVisible(true);

        //create instruction label and add to frame
        instructions = new JLabel("Follow the instructions on the exam to use this program");
        this.add(instructions);

        //create textfield for index entry and add to frame
        indexEntry = new JTextField();
        this.add(indexEntry);

        //create button for average and add to frame
        avgBtn = new JButton("Click for Average");
        this.add(avgBtn);
        avgBtn.addActionListener(this);

        //create panel to display results and add to frame
        resultsPanel = new JPanel();
        resultsPanel.setBackground(Color.BLUE);
        this.add(resultsPanel);

        //read in from file
        readFromFile();

        //compute average
        computeAverage();
        System.out.println(avg);
    }

    private void readFromFile() {
        try {
            // Open the file that is the first
            // command line parameter
            FileInputStream fstream = new FileInputStream("numbers.dat");
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            int i = 0;
            while ((strLine = br.readLine()) != null) {
                // Print the content on the console
                System.out.println (strLine);
                intArray[i] = Integer.parseInt(strLine);
                numOfInts++;
                i++;
            }
            //Close the input stream
            in.close();
            System.out.println ("numOfInts = " + numOfInts);
        }
        catch (Exception e) {
            //Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }
    private void computeAverage() {
        int sum = 0;
        for (int i = 0; i < numOfInts; i++)
        sum += intArray[i];
        avg = sum/numOfInts;
        //return avg;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == avgBtn) {
            computeAverage();
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.setVisible(true);
    }
}