package TCPRequester;

import java.util.*;

public class AffdexArray
{

private float valence = 0.0f;
private float previousValenceData = 0.0f;

private static int totalBuffer = 0;
public static float valenceSum = 0f;
private static float valenceTotal = 0f;

private static final int FACEID_INDEX = 6;
private static final int VALENCE_INDEX = 17;   
public static ArrayList<Float> valenceArray; 

public AffdexArray()
{

    valenceArray = new ArrayList<Float>();    
    //initialise the timer to the earliest time in systems

}

void ValenceCalculation() throws InterruptedException
{  
    //Set timer for ten seconds then when it has passed, do system
    Timer mathsTimer = new Timer();
    TimerTask myTask = new TimerTask()
    {
        public void run()
        {
        for(int i = 0; i<valenceArray.size();i++)
                {           
                valenceSum += valenceArray.get(i);
                //add all values and divide by clicker amount. (mean?)
                }
            //after 10 seconds grab the values in buffer and clicker amount.
            valenceTotal = valenceSum / totalBuffer;
            System.out.println("Valence Average = " + valenceTotal); 
            System.out.println("Data Count: " + valenceArray.size());;
            //Transfers float value into new variable
            //previousValenceData = valenceTotal;
            //clear buffer and reset timer
            valenceArray.clear();
            totalBuffer = 0;
            valenceSum = 0; 
        }
    };mathsTimer.schedule(myTask, 0, 5000);
}


public void valenceProcess(String[] inArray) 

{
    if(inArray[FACEID_INDEX].equals("1"))
    {
    //this needs to be a repeatable process

            valence = Float.parseFloat(inArray[VALENCE_INDEX]);
            //places the valence value into an Array list
            valenceArray.add(valence);
            //adds 1 a click to every input into that buffer
            totalBuffer++;   
            } else {
        } 
}