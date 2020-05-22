import javax.swing.JOptionPane;
public class Temp3 {

    public static void main(String[] args) {
            // String sentence = "This is a Java program for converting
            // temperatures.";
            String [] options = {"Convert from Celsius to fahrenheit", "Convert from Fahrenheit to Celsios","Exit"};
            int choice=0;
            do{ //do while is used so that the loop will run AT LEAST ONCE
                 choice = JOptionPane.showOptionDialog(null,"What do you want to do?", 
                        "Choose an option", JOptionPane.YES_NO_CANCEL_OPTION, //option type 
                        JOptionPane.QUESTION_MESSAGE, 
                        null, options, options[0]);
                 convertTemp(choice);
            }while(choice!=2);

    }

    private static void convertTemp(int choice) {
        // TODO Auto-generated method stub
        String from = "", to = "";
        if(choice==0){ //set to and form so that you don't need to type the units again and again 
            from="Celsius"; 
            to ="Fahrenheit";
        }else if(choice==1){
            to="Celsius"; 
            from ="Fahrenheit";
        }else{
            JOptionPane.showMessageDialog(null,"Goodbye","Exit",JOptionPane.INFORMATION_MESSAGE);
            //I often put message type to make it more presentable
            return; //exit method :) 
        }
        Float tempFrom= Float.parseFloat(JOptionPane.
                showInputDialog("You are now converting from "+from+" to "+ to+"."
                        + "Please enter degrees in "+from +".")); //get input 
        while(tempFrom<-100 ||tempFrom>100){ //check if input is valid 
            if(tempFrom>100){
                tempFrom = Float.parseFloat(JOptionPane.showInputDialog(null, "That number is too high. "
                        + "Please enter a temperature between -100 & 100 degress "+from , "Temperature too high"
                        , JOptionPane.ERROR_MESSAGE));//inform the user about the error and ask for the input at the same time 
            }else{
                tempFrom = Float.parseFloat(JOptionPane.showInputDialog(null, "That number is too low. "
                        + "Please enter a temperature between -100 & 100 degress "+from , "Temperature too low"
                        , JOptionPane.ERROR_MESSAGE));//inform the user about the error and ask for the input at the same time
            }
        }
            double answer =0;
            if(choice==0){ //celsius to fahrenheit 
                answer = (tempFrom * 1.8) + 32;
            }else{ //fahrenheit to celsius 
                answer = (tempFrom- 32) / 1.8;
            }
            JOptionPane.showMessageDialog(null, "The temperature in "+ to +" is " +
                    answer  
                    ,to,
                    JOptionPane.INFORMATION_MESSAGE);
    }
}