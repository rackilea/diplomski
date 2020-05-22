Scanner in = new Scanner(System.in);
Random gen = new Random();
int rollDice;
int one = 0, two = 0, three = 0, four = 0, five = 0, six = 0;

System.out.println("How many die do you want to roll: ");

int dice = in.nextInt();

while(dice > 0)
{
    rolldice = gen.nextInt(6) + 1;  //(1-6)
    if (rolldice == 1)
    {
        one++;
    }
    else if (rolldice == 2)
    {
        two++;
    }
    else if (rolldice == 3)
    {
        three++;
    }
    else if (rolldice == 4)
    {
        four++;
    }
    else if (rolldice == 5)
    {
        five++;
    }
    else if (rolldice == 6)
    {
        six++;
    }
    dice--;
}