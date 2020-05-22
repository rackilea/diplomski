final double first=198.4;//value extract by unmodifiable format method
final double second=44701.2;//value extract by unmodifiable format method
final double firstDifference= first+second; //I receive 44899.6
final double calculatedDifference=44900.1; // comparison value for the flow
final double error=firstDifference-calculatedDifference;// I receive -0.5 

if(Math.abs(error)<=0.5d){
    // this branch is entered.
    System.out.println(error);
}