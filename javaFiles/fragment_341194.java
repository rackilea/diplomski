import javax.swing.JOptionPane;
public class HelloWorld
{
  public static void main(String[] args) {
      int prompt;
      int[] carsValues = new int[6];//didnt want to use 0
      do{
          prompt = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter"
              + "\n"
              + "1 For Honda"
              + "\n"
              + "2 For Toyota"
              + "\n"
              + "3 For Ford"
              + "\n"
              + "4 For Chevrolet"
              + "\n"
              + "5 For Kia"
              + "\n"
              + "6 To Quit"));
          if(prompt < 0 || prompt > 6){
            JOptionPane.showMessageDialog(null, "Unrecognizable Command"
                                                + "\n"
                                                + "Error: Entered Option must be between 1 and 5 inclusive"
                                                + "\n"
                                                + "Try Again"
                                                + "\n");
          }
          else{
              int n = prompt;
              carsValues[n]++;
              display(carsValues);
          }
      }while(prompt!= 6);
  }
  public static void display(int[] input){
      try{
          int miles, gallons, mpg;
          miles = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Miles Driven "));
          if (miles <= -1){
              JOptionPane.showMessageDialog(null,"Input Is Negative"
                      + "\n"
                      + "Try Again");
          miles = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Miles Driven ")); 
          }
          gallons = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Gallons Used "));
          if (gallons <= -1){
              JOptionPane.showMessageDialog(null,"Input Is Negative"
                      + "\n"
                      + "Try Again");
          gallons = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Gallons Used ")); 
          }
              mpg = miles/gallons;
              JOptionPane.showMessageDialog(null, String.format("MPG Turns Out To Be %n" + mpg));
      }catch(ArithmeticException mathError){
              JOptionPane.showMessageDialog(null, "Division by Zero"
                  + "\n"
                  + "Can't Do That");   
          }
          JOptionPane.showMessageDialog(null, "Amount of Times Chosen"
                + "\n"
              + "Honda: " + input[1]
              + "\n"
              + "Toyota: " + input[2]
              + "\n"
              + "Ford: "  + input[3]
              + "\n"
              + "Chevrolet: " + input[4]
              + "\n"
              + "Kia: " + input[5]
              + "\n");
  }
}