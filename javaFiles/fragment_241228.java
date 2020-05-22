public class DogTriathlonParticipant {

//private static int NUM_EVENTS;
//private static int totalCumulativeScore = 0; //this logic is not part of DogTriathlonParticipant.

// you should not put final if you plan to edit the variable.
private String name;
private int obedienceScore;
private int conformationScore;
private int agilityScore;
private int total;
private double avg;
private String name;

public DogTriathlonParticipant (String name, int numEvents, int score1, int score2, int score3) {
    this.name = name;
    // NUM_EVENTS = numEvents; this logic don't belong here
    obedienceScore = score1;
    conformationScore = score2;
    agilityScore = score3;

    total = obedienceScore + conformationScore + agilityScore;
    avg = (double) total / numEvents; // edited here, I think you are trying to get the average of to total by numEvents, in this case, the score1 shoulb be the sum of the events "numEvents".
    //totalCumulativeScore = totalCumulativeScore + total; 
}

public void display()
    {
        System.out.println(name + " participated in " + numEvents+ " Events and has an average score of " + avg);
        System.out.println( " " + name + " has total score of " + total + " bringing the total cumlative score to " + total);
    } 
 }