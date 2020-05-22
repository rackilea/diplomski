int totalSum = 0;    // Declare a variable outside it..
for (int s=0; s < 51; s++)   // This is the place where the loop started
{
   fmt = new Formatter();
   fmt.format("%20s", states[s]);
   System.out.print(fmt);

   // Other inner loops

    int sum =0;   // Your innerloop that calculates sum of each state..
    for (int col=0; col < votes[s].length; col++)
     {
      sum = sum + votes[s][col];

    }

    totalSum += sum;   // Add sum to `totalSum`
    fmt = new Formatter();
    fmt.format("%21d", sum);  
    System.out.print(fmt);

    // Continue with the outer loop
}