import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DivingCompetition
{
    static DiverComparator comp = new DiverComparator();
    static Set<Diver> divers = new TreeSet<Diver>(comp); 

    public static void main(String[] args)
    {
        String[] choices = {"Add Diver/Scores", "View Diver Standings", "Search for a diver", "Exit Program"};
        String input = (String) JOptionPane.showInputDialog(null, "What do you want to do?", "Diving Competition", 
                JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
        while(!input.equals("Exit Program"))
        {
            if (input.equals("Add Diver/Scores"))
                addDiver();
            else if (input.equals("View Diver Standings"))
                viewStandings();
            else if (input.equals("Search for a diver"))
                searchDiver();
            else
                System.exit(0);
            input = (String) JOptionPane.showInputDialog(null, "What do you want to do?", "Diving Competition", 
                    JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);      
        }
    }
    public static void addDiver()
    {
        String scoreInvalid = "The score must be between 0 and 10";
        String difficultyInvalid = "The difficulty must be between 1.2 and 3.8";
        double[] scores = new double[7];
        int i = 0;
        String tempScore = "";
        String tempDifficulty = "";
        double realDifficulty = 0;
        double realScore = 0;
        int numScores = 0;

        String diverName = JOptionPane.showInputDialog("Please enter the diver's name:");
        while (numScores < 7)
        {
            tempScore = JOptionPane.showInputDialog("Please enter the seven judge's scores one at a time");
            realScore = Double.parseDouble(tempScore);
            while (realScore < 0 || realScore > 10)
            {
                JOptionPane.showMessageDialog(null, scoreInvalid, "Invalid Score", JOptionPane.WARNING_MESSAGE);
                tempScore = JOptionPane.showInputDialog("Please enter the corrected score");
                realScore = Double.parseDouble(tempScore);
            }

            scores[i] = realScore;
            i++;
            numScores++;
        }
        tempDifficulty = JOptionPane.showInputDialog("Please enter the difficulty rating of the dive");
        realDifficulty = Double.parseDouble(tempDifficulty);

        while (realDifficulty < 1.2 || realDifficulty > 3.8)
        {
            JOptionPane.showMessageDialog(null, difficultyInvalid, "Invalid Difficulty", JOptionPane.WARNING_MESSAGE);
            tempDifficulty =  JOptionPane.showInputDialog("Please enter the                 corrected difficulty rating of the dive");
            realDifficulty = Double.parseDouble(tempDifficulty);
        }
        Diver aDiver = new Diver(diverName, scores, realDifficulty);

        divers.add(aDiver);
    }
    public static void viewStandings()
    {
        Object[][] rows = new Object[divers.size()][]; 
        int i = 0;
        for(Diver d : divers) {
            rows[i] = new Object[3];
            rows[i][0] = i+1;
            rows[i][1] = d.getName();
            rows[i][2] = d.getFinalScore();
            i++;
        }
            Object[] cols = {
                "Rank","Name","Final Score"
            };
            JTable table = new JTable(rows, cols);
            JOptionPane.showMessageDialog(null, new JScrollPane(table));

    }
    public static void searchDiver()
    {

    }    
}
class DiverComparator implements Comparator<Diver> {

    @Override
    public int compare(Diver o1, Diver o2) {

        // TODO Auto-generated method stub
        return (int) (o2.getFinalScore() - o1.getFinalScore());
    }

}