import java.text.DecimalFormat;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;
import java.util.Random;

//This lab is to study periodc table of elements with simple gui output
public class PracticeFiftyEight {
    final static String[] arrayElements = {"Hydrogen","Helium","Lithium","Beryllium","Boron","Carbon","Nitrogen","Oxygen","Fluorine","Neon","Sodium","Magnesium",
                                            "Aluminium","Silicon","Phosphorus","Sulfur","Chlorine","Argon","Potassium","Calcium","Scandium","Titanium","Vanadium",
                                            "Chromium","Manganese","Iron","Cobalt","Nickel","Copper","Zinc","Gallium","Germanium","Arsenic","Selenium","Bromine",
                                            "Krypton","Rubidium","Strontium","Yttrium","Zirconium","Niobium","Molybdenum","Technetium","Ruthenium","Rhodium",
                                            "Palladium","Silver","Cadmium","Indium","Tin","Antimony","Tellurium","Iodine","Xenon","Cesium","Barium"};

    final static String[] arrayEleAbriv = {"H","He","Li","Be","B","C","N","O","F","Ne","Na","Mg","Al","Si","P","S","Cl","Ar","K","Ca","Sc","Ti","V","Cr","Mn","Fe","Co","Ni","Cu","Zn","Ga","Ge","As",
                "Se","Br","Kr","Rb","Sr","Y","Zr","Nb","Mo","Tc","Ru","Rh","Pd","Ag","Cd","In","Sn","Sb","Te","I","Xe","Cs","Ba"};

    public static void main(String[] args) {            

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                String input;

                boolean answer;

                Random myRan = new Random();

                int randInt = 0;
                 //random num from 0 - 56                   

                int repeat;

                do {
                    randInt = myRan.nextInt(56);

                    JOptionPane.showMessageDialog(null, " sizes of arrays " + arrayElements.length + " " + arrayEleAbriv.length);

                    JOptionPane.showMessageDialog(null, " What is the symbol of " + arrayElements[randInt]);

                    input = JOptionPane.showInputDialog(null," Enter element symbol ( 1 - 56 ) of");

                    if(input != null) { // if user press cancel, input is null
                        answer = input.equalsIgnoreCase(arrayEleAbriv[randInt]);

                        if(answer) {
                            JOptionPane.showMessageDialog(null, " Correct " + arrayElements[randInt] + " is represented by " + arrayEleAbriv[randInt] );
                        } else {
                            JOptionPane.showMessageDialog(null, " WRONG!!!!! " + arrayElements[randInt] + " is represented by " + arrayEleAbriv[randInt] + " !!!!! " );
                        }
                    } else {
                        System.out.println("input is null: " + input);
                    }

                    repeat = JOptionPane.showConfirmDialog(null, "Press Yes to repeat, No to quit ", "please confirmm", JOptionPane.YES_NO_OPTION);

                } while(repeat == JOptionPane.YES_OPTION);
            }
        });
    }
}