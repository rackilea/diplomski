static int getAndVerfyInput(String userPrompt, int lowerBound, int upperBound)
{


    int result;

    Scanner keyboard = new Scanner(System.in);  

    do{
        System.out.println(userPrompt);
        result = keyboard.nextInt();    

    } while (result < lowerBound || result > upperBound);



    return result;
}