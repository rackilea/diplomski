public static void takeTest(Question[]questions){
    int score = 0;
    int index;
    Question temp;
    Scanner keyboardInput = new Scanner(System.in);

    Random rnd = new Random();
    for(int i= questions.length -1; i>0; i--){
        index = rnd.nextInt(i+1);
        questions[index] = questions[i];
        questions[i]=temp;
        temp = questions[index];

        System.out.println(questions[i].prompt);
        String a = keyboardInput.nextLine();          

        if (a.equalsIgnoreCase(questions[i].answer)) {
            score++;
        }else if(a.equalsIgnoreCase(questions[i].alternative)){
            score++;
        }
    } 
    System.out.println("You got " + score + " out of " + questions.length);
}