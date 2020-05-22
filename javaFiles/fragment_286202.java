import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.util.Scanner;

public class MyBot {
    public static void main(String[] args)
            throws AWTException{

        Robot myRobot = new Robot();

        while(!StopRobot())
        {
            for(int i=0;i<300;i++){//the robot works just fine
                Color color = myRobot.getPixelColor(i,190);

                if((color.getRed()==0 && color.getGreen()==0 && color.getBlue()==0)){
                    myRobot.mouseMove(i,190);
                }
            }
        }
    }

    public static boolean StopRobot() {
        boolean isStop = false;
        Scanner Key = new Scanner(System.in);

        System.out.println("A"); // A prints
        String F = Key.nextLine();

        System.out.println("B"); // B does not print

        if (F.equals(" "))
        {
            System.out.println("C"); // B does not print
            //System.exit(0);// 'Space' is the button to stop the program
            isStop = true;

        }

        return isStop;
    }
}