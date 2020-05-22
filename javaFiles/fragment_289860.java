public static void main(String [] args){
    String forename, surname, tempStr, InputFileName, OutputFileName, nextLine;
    int sum = 0;
    float average;
    nextLine = "";
    tempStr = "Mildred Bush 45 65 45 67 65";

    String[] list = tempStr.split(" ");
    forename = list[0];
    surname = list[1];
    int[] scores = new int[5];
    scores[0] = Integer.parseInt(list[2]);
    scores[1] = Integer.parseInt(list[3]);
    scores[2] = Integer.parseInt(list[4]);
    scores[3] = Integer.parseInt(list[5]);
    scores[4] = Integer.parseInt(list[6]);
    System.out.println("Forename : "+ forename);
    System.out.println("Surname : "+ surname);
    System.out.print("Scores : ");
    for(int eachInt : scores){
        sum+=eachInt;
        System.out.print(eachInt+" ");
    }
    System.out.println();
    System.out.println("Average : " + sum/scores.length);
}