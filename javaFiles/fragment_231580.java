import java.security.SecureRandom;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Random {
    public int randomNum;
    public String ID;

    public Random(String ID,int initialValue){
        SecureRandom randomNumbers = new SecureRandom();
        this.ID = ID;
        this.randomNum = initialValue;
        int randomValue = randomNumbers.nextInt(99)+1;
        randomNum = randomValue;
    }

    public int getRandomNum(){
        return randomNum;
    }

    public String getID(){
        return ID;
    }

    public String toString(){
        return ID + ": " + randomNum;
    }
}

class RandomText{
    public static void main(String[] args) {
        int ans = Integer.parseInt(JOptionPane.showInputDialog
                ("How many random number you want to show?"));

        ArrayList<Random> randomNum = new ArrayList<Random>();
        for (int i = 0; i < ans; i++) {
            randomNum.add(new Random("ID " + Integer.toString(i),0));
        }
        String result = "";
        for (int i = 0; i < ans; i++) {
            result = result + randomNum.get(i).toString() + "\n";
        }
        JOptionPane.showMessageDialog(null, result);

    }
}