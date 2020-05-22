final int first=1984;// 198.4 * 10
final int second=447012; // 44701.2 * 10
final int firstDifference= first+second;  //I receive 448996
final int calculatedDifference=449001; // comparison value for the flow
final int error=firstDifference-calculatedDifference;// I receive -5 

if(Math.abs(error)<=5){
    // this branch is entered.
    System.out.println(error);
}