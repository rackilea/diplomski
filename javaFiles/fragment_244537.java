public class Sizer extends WindowAdapter 
{
    public static void main (String[]args){

        JFrame m = new JFrame();
        int height = 0;

        JOptionPane.showMessageDialog(m,"Ok To set the window size you are going to type in the number for each value REMEMBER THE SIZE IS IN PIXELS");

        do {
            String input1= JOptionPane.showInputDialog("Height (suggested under 1080 and above 300)");
            height= Integer.parseInt(input1);
            int a1 = JOptionPane.showConfirmDialog(m,"Are you sure that this is the correct Height "+ height);

             if (a1==JOptionPane.NO_OPTION){
                height = 0;
            }

        } while (height==0)
    }

}