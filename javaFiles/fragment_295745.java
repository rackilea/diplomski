final int EXAMS = 5;
Integer[] scores = new Integer [EXAMS]; // the only required change
for (int index = 0; index < EXAMS; index++) {
    System.out.println("Enter the score for " + (index+1) +":");
    scores[index] = kb.nextInt();
    if (scores[index] < 0){
        System.out.println("The number you have entered is invalid.");
        scores[index] = kb.nextInt();
    }
}
Arrays.sort(scores, Collections.reverseOrder());
System.out.println("The sorted int array is:");
for (int number : scores)  {
    System.out.println("Number = "+ number);
}