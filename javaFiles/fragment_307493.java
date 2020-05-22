public static void main(String random[])
{
    Scanner s = new Scanner(System.in);

    int input = new int[5];
    int[] arrayone = new int[4096];

    int loop = 0;

    //don't do anything here except fill the array with values
    for(int i = 0; i < arrayone.length; i++) {
        arrayone[i] = (int)(Math.random() * 99999 + 1);
    }

    //ask the user for 5 inputs
    for (int index = 0; index < input.length; index++) {

        System.out.println("Please enter a number between " + min + " and " + max);
        input[index] = s.nextInt();
        //check to see if the number is valid
        if (min <= input[index] && input[index] <= max) {
            //loop through the arrayone to determine where it is
            for(int i = 0; i < arrayone.length; i++) {
                //if it is not in the current index at i increment the loop count
                if (arrayone[i] != input[index]) {
                    loop++;
                }
                //we have found where it is and should break out of the loop
                else {
                    break;
                }
            }
            //check if we found it based on how much we incremented
            if(i != arrayone.length)
            {
                //output how long it took to find the number
                System.out.println("It took " + loop + " time(s) to find the number " + input[index]);
            }
            else
            {
                System.out.println(input[index] + " not found!");
            }
            //now reinitialize the loop to 0 for the next guess
            loop = 0;
        }   
    }
    //always remember to close your scanners
    s.close();
    }

}