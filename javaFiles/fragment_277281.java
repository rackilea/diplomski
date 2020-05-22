class temp1
{
    public static void main(String args[])
    {
        int counter = 0;
        String question;
        question = "How many elements do you want?: ";
        EasyReader console = new EasyReader();
        System.out.println(question);
        int answer;
        int answer2;
        answer = console.readInt();
        int[] numbers = new int[answer];
        int mean;
        System.out.println();
        while (true)
        {
            System.out.println("Please enter a number: ");
            answer2 = console.readInt();
            numbers[counter] = answer2;
            counter++;
            if (counter == answer)
            {
                break;
            }
        }
        counter = 0;
        int sum = 0;
        while(true)
        {
            sum = sum + numbers[counter];
            counter++;
            if(counter == answer)
            {
                break;
            }
        }
        mean = sum / answer;
        System.out.print(mean);
    }
}