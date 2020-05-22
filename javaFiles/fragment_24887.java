import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;


public class test extends JFrame implements ActionListener {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    test frame = new test();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */



    //TODO  
    int numOfStations = 6;
    boolean cleared[] = new boolean[21];
    boolean finalCleared = false;
    int randnum[] = new int [numOfStations+1];
    int numOfRotations = 1;
    String[] String_CurrentOperator = new String[numOfStations+1];
    Random rand_opers = new Random();

    List<Integer> ArrayList_UsedRandNums = new ArrayList<>();
    List<List<String>> ArrayList_MainOperatorHistory = new ArrayList<List<String>>();
    List<String> ArrayList_AllOpers = new ArrayList<>();
    List<String> ArrayList_CurrentRotationOperators = new ArrayList<>();
    List<String> ArrayList_UsedOpers = new ArrayList<>();
    List<String> ArrayList_OperatorHistory1 = new ArrayList<>(); 
    List<String> ArrayList_OperatorHistory2 = new ArrayList<>(); 
    List<String> ArrayList_OperatorHistory3 = new ArrayList<>(); 
    List<String> ArrayList_OperatorHistory4 = new ArrayList<>(); 
    List<String> ArrayList_OperatorHistory5 = new ArrayList<>(); 
    List<String> ArrayList_OperatorHistory6 = new ArrayList<>(); 
    List<String> ArrayList_OperatorHistory7 = new ArrayList<>(); 
    List<String> ArrayList_OperatorHistory8 = new ArrayList<>(); 
    List<String> ArrayList_OperatorHistory9 = new ArrayList<>(); 
    List<String> ArrayList_OperatorHistory10 = new ArrayList<>(); 


    public test() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout(0, 0));

        JButton btnShuffle = new JButton("SHUFFLE");
        contentPane.add(btnShuffle, "name_253561263644851");
        btnShuffle.addActionListener(this);

        ArrayList_AllOpers.add("POSITION ZERO");
        ArrayList_AllOpers.add("A");
        ArrayList_AllOpers.add("B");
        ArrayList_AllOpers.add("C");
        ArrayList_AllOpers.add("D");
        ArrayList_AllOpers.add("E");
        ArrayList_AllOpers.add("F");
        ArrayList_AllOpers.add("Greek");
        ArrayList_AllOpers.add("Hospital");
        ArrayList_AllOpers.add("Indigo");
        ArrayList_AllOpers.add("Juliette");

        ArrayList_MainOperatorHistory.add(ArrayList_OperatorHistory1);
        ArrayList_MainOperatorHistory.add(ArrayList_OperatorHistory1);
        ArrayList_MainOperatorHistory.add(ArrayList_OperatorHistory2);
        ArrayList_MainOperatorHistory.add(ArrayList_OperatorHistory3);
        ArrayList_MainOperatorHistory.add(ArrayList_OperatorHistory4);
        ArrayList_MainOperatorHistory.add(ArrayList_OperatorHistory5);
        ArrayList_MainOperatorHistory.add(ArrayList_OperatorHistory6);
        ArrayList_MainOperatorHistory.add(ArrayList_OperatorHistory7);
        ArrayList_MainOperatorHistory.add(ArrayList_OperatorHistory8);
        ArrayList_MainOperatorHistory.add(ArrayList_OperatorHistory9);
        ArrayList_MainOperatorHistory.add(ArrayList_OperatorHistory10);
    }


    public void actionPerformed(ActionEvent arg0) {
        finalCleared = false;
        for(int j=1; j<numOfStations+1; j++){       
            cleared[j]=false;           
        }

        for(int j=numOfStations+1; j<21; j++){  
            cleared[j]=true;            
        }

        /*******************************
         *****ASSIGN ALL OPERATORS******
         *******************************/
        //System.out.println("THIS IS ROTATION "+numOfRotations);

        for(int i=1; i<1+1; i++){
            do{
                //clears the list of operators used during last rotation                
                ArrayList_CurrentRotationOperators.clear();

                //Assign the operators
                for(int j=1; j<numOfStations+1; j++){       
                    String_CurrentOperator[j] = ArrayList_AllOpers.get(randnum[j]);     
                }

                //1. Ensure assigned operators or unique else fail finalCleared check
                //2. If finalCleared is true then exit do and for loops
                for(int j=1; j<numOfStations+1; j++){       
                    if (ArrayList_MainOperatorHistory.get(j).contains(String_CurrentOperator[j]) || ArrayList_CurrentRotationOperators.contains(String_CurrentOperator[j])){
                        cleared[j]=false;
                    }
                    else{
                        cleared[j]=true;
                        ArrayList_CurrentRotationOperators.add(String_CurrentOperator[j]);
                    }           
                }


                if (cleared[1]==true && cleared[2]==true && cleared[3]==true && cleared[4]==true && cleared[5]==true && cleared[6]==true 
                        && cleared[7]==true && cleared[8]==true && cleared[9]==true && cleared[10]==true){
                    finalCleared=true;
                }
                else{
                    genRandoms();
                }
            }
            while(finalCleared == false);
        }

        //1. Prints the name of the operator working on the station
        //2.  Adds operator to list of all users who have been assigned to station
        for(int i=1; i<numOfStations+1; i++){
            System.out.print(String_CurrentOperator[i]+" ");                                      
            ArrayList_MainOperatorHistory.get(i).add(String_CurrentOperator[i]);
        }

        //Perform cleanup actions for next iteration of the loop
        //1.  increment the rotation count by 1
        numOfRotations++;              
        System.out.println("");
    }   



    /*********************
     **genRandoms Method**
     *********************/
    public void genRandoms(){
        for(int i=1; i<numOfStations+1; i++){
            randnum[i] = rand_opers.nextInt(numOfStations)+1;
        }
    }
}