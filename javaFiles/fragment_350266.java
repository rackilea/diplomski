import java.util.Random;
import java.util.LinkedList;
import java.util.ArrayList;

public class AirportQueue {

public Random rand = new Random();
public int partySize;
public Random randQueue = new Random();
public LinkedList<Integer> airportQ1 = new LinkedList<>();
public LinkedList<Integer> airportQ2 = new LinkedList<>();
public LinkedList<Integer> airportQ3 = new LinkedList<>();
public ArrayList[] minute = new ArrayList[500];
public ArrayList[] secondMinute = new ArrayList[250];
public ArrayList<Integer> q1 = new ArrayList(0);
public ArrayList<Integer> q2 = new ArrayList(0);
public ArrayList<Integer> q3 = new ArrayList(0);
public int avgQ1 = 0;
public int avgQ2 = 0;
public int avgQ3 = 0;
public int max1 = 0;
public int max2 = 0;
public int max3 = 0;
public int countQ1 = 0;
public int countQ2 = 0;
public int countQ3 = 0;

public void airportSimulation() {

    int queueSelected = randQueue.nextInt(3);

    //Simulate queues for 500 minutes
    for (int i = 1; i < 501; i++) {
        //add a party to a queue each minute
        if ((i % 2) == 0) {
            if ((airportQ1.size() <= airportQ2.size()) && (airportQ1.size() <= airportQ3.size())) {
                partySize = rand.nextInt(4) + 1;
                airportQ1.add(partySize);
                q1.add(partySize);
                System.out.println("Minute " + i + ": a party of " + partySize + " just entered the queue.");
            } else if ((airportQ2.size() <= airportQ1.size()) && (airportQ2.size() <= airportQ3.size())) {
                partySize = rand.nextInt(4) + 1;
                airportQ2.add(partySize);
                q2.add(partySize);
                System.out.println("Minute " + i + ": a party of " + partySize + " just entered the queue.");
            } else//((airportQ3.size() <= airportQ1.size()) && (airportQ3.size() <= airportQ2.size())) 
            {
                partySize = rand.nextInt(4) + 1;
                airportQ3.add(partySize);
                q3.add(partySize);
                System.out.println("Minute " + i + ": a party of " + partySize + " just entered the queue.");
            }

            //remove a party every 2 minutes
            if (queueSelected == 0) {
                if (airportQ1.size() != 0) {
                    airportQ1.remove();
                    if (airportQ1.size() > 0) {
                        System.out.println("Minute " + i + ": a party of " + airportQ1.get(airportQ1.size() - 1) + " just passed security.");
                    }
                }
            } else if (queueSelected == 1) {
                if (airportQ2.size() != 0) {
                    airportQ2.remove();
                    if (airportQ2.size() > 0) {
                        System.out.println("Minute " + i + ": a party of " + airportQ2.get(airportQ2.size() - 1) + " just passed security.");
                    }
                }
            } else {
                if (airportQ3.size() != 0) {
                    airportQ3.remove();
                    if (airportQ3.size() > 0) {
                        System.out.println("Minute " + i + ": a party of " + airportQ3.get(airportQ3.size() - 1) + " just passed security.");
                    }
                }
            }
            queueSelected = randQueue.nextInt(3);

        } else {
            if ((airportQ1.size() <= airportQ2.size()) && (airportQ1.size() <= airportQ3.size())) {
                partySize = rand.nextInt(4) + 1;
                airportQ1.add(partySize);
                q1.add(partySize);
                System.out.println("Minute " + i + ": a party of " + partySize + " just entered the queue.");
            } else if ((airportQ2.size() <= airportQ1.size()) && (airportQ2.size() <= airportQ3.size())) {
                partySize = rand.nextInt(4) + 1;
                airportQ2.add(partySize);
                q2.add(partySize);
                System.out.println("Minute " + i + ": a party of " + partySize + " just entered the queue.");
            } else {
                partySize = rand.nextInt(4) + 1;
                airportQ3.add(partySize);
                q3.add(partySize);
                System.out.println("Minute " + i + ": a party of " + partySize + " just entered the queue.");
            }
        }

        //num of people in queue
        int q1Total = 0;
        for (int k = (airportQ1.size() - 1); k > 0; k--) {
            q1Total = q1Total + airportQ1.get(k);
            avgQ1 = q1Total / 500;
            q1.add(q1Total);
        }
        int q2Total = 0;
        for (int k = 1; k < airportQ2.size(); k++) {
            q2Total = q2Total + q1.get(k);
            q2.add(q2Total);
        }
        int q3Total = 0;
        for (int k = 1; k < airportQ3.size(); k++) {
            q3Total = q3Total + airportQ3.get(k);
            q3.add(q3Total);
        }
    }

    //avg number of people in each queue
    for (int m = 1; m < q1.size(); m++) {
        countQ1 = q1.get(m) + countQ1;
    }
    for (int m = 1; m < q2.size(); m++) {
        countQ2 = q2.get(m) + countQ2;
    }
    for (int m = 1; m < q3.size(); m++) {
        countQ3 = q3.get(m) + countQ3;
    }
    avgQ1 = countQ1 / (q1.size() - 1);
    avgQ2 = countQ2 / (q2.size() - 1);
    avgQ3 = countQ3 / (q3.size() - 1);

    //Max value for each queue
    for (int j = 0; j < q1.size(); j++) {
        int current1 = q1.get(j);
        if (current1 > max1) {
            max1 = current1;
        }
    }
    for (int i = 0; i < q2.size(); i++) {
        int current2 = q2.get(i);
        if (current2 > max2) {
            max2 = current2;
        }
    }
    for (int i = 0; i < q3.size(); i++) {
        int current3 = q3.get(i);
        if (current3 > max3) {
            max3 = current3;
        }
    }

    System.out.println("The average number of people in the first "
            + "Airport Security queue is " + avgQ1);
    System.out.println("The average number of people in the second "
            + "Airport Security queue is " + avgQ2);
    System.out.println("The average number of people in the third "
            + "Airport Security queue is " + avgQ3);
    System.out.println("The maximum number of people in the first "
            + "queue at any given time was " + max1);
    System.out.println("The maximum number of people in the second "
            + "queue at any given time was " + max2);
    System.out.println("The maximum number of people in the third "
            + "queue at any given time was " + max3);

}

public static void main(String[] args) {
    AirportQueue testAirport = new AirportQueue();
    testAirport.airportSimulation();
}
}