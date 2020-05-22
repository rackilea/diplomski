int next,sum = 0;

while(square.hasNextInt())
{
    next = square.nextInt();
    System.out.println(next+"\n");
    sum = next + sum; 
}