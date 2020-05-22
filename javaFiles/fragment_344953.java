import java.util.Random;
import java.util.Scanner;

public class SurvivalGameVersionTwo
{
private int Repeat;
public int WinLose = (1);
private int Turn = (1);

public static void main(String[] args)
{

    String User;
    int Repeat = (3);//changed: to enter into while loop Repeat should be more than 2

    //Creating Objects

    SurvivalGameVersionTwo game = new SurvivalGameVersionTwo();
    Score score = new Score();
    Grid grid = new Grid();
    Spawner spawner = new Spawner();
    Display display = new Display();
    User user = new User();
    Time time = new Time();
    Logic logic = new Logic();
    Movement movement = new Movement();

    //Calling object's class methods

    Intro();
    User = GetUser();
    user.setName(User);

    while (Repeat > 2)//changed: removed ;
    {

        game.Ready();
        grid.RandomGridGenerator();
        movement.Copy();//changed:First copy then change GridCompOne array
        spawner.RabbitWolfSpawner();


        while (game.WinLose <= 2)
        {
            display.UserGrid();
            game.Turn = Turns(game.Turn);
            movement.Movement();
            game.WinLose = logic.WinLose(game.Turn);
            time.Delay();
        }
        display.UserGrid();
        Repeat = Repeat();
        game.WinLose = (1);
    }
}
public static void Intro()
{
    System.out.printf("Welcome to the Rabbit Survival Game!\n");
    System.out.println("Rules to win: Rabbit must cross the bridge.");
    System.out.println("Rules to lose: Rabbir drowns in the water, \n"+
            "eaten by the wolf, or starve to death in 30 turns.");
    System.out.println("------------------------------------------");
}
public static String GetUser()
{
    Scanner Input = new Scanner (System.in);
    String Name;
    System.out.println("Please type in your name please.");
    Name = Input.next();
    return Name;
}
public static void Ready()
{
    Scanner Input = new Scanner (System.in);
    String Ready;
    String Yes = ("Yes");
    String No = ("No");
    System.out.println("Are you ready to play?");
    System.out.println("Type in 'Yes', or 'No' to continue.");
    Ready = Input.next();
    if (Ready.equals(Yes) == true)
    {
        System.out.println("Lets begin!!!");
    }
    else if (Ready.equals(No) == true)
    {
        System.out.println("Goodbye, and hope you come back to play again.");
        System.exit(0);
    }
    else
    {
        System.out.println("There was an error!!! Restart the program to try again.");
        System.exit(0);
    }
}
public static int Turns(int turns)
{
    int Turns;
    System.out.printf("Turn %d.",turns);
    Turns = (turns + 1);
    return Turns;
}
public static int Repeat()
{
    Scanner Input = new Scanner (System.in);
    int repeat;
    System.out.println("Do you wish to play again?");
    repeat = Input.nextInt();
    return repeat;
}
}

class User
{
private String Name;

public void UserInfo(String name)
{
    this.Name=name;
}
public String getName() {
    return Name;
}
public void setName(String name) {
    Name = name;
}
}

class Score
{
public static int Total = 0;
public static int Win = 0;
public static int Lose = 0;
public static double Ratio = 0;
}
class Grid {
public static int[][] GridCompOne = new int[10][10];
public static int[] Rabbit = new int[2];
public static int[] Wolf = new int[2];

public static void RandomGridGenerator() {
    Random r = new Random();

    int i = 1;
    int j = 1;
    int k = 0;
    int Low = 1;
    int High = 3;
    int Random;

    //parameters for bridge and water spawning

    while (k <= 9) {
        Random = r.nextInt(High - Low) + Low;
        GridCompOne[0][k] = Random;
        Random = r.nextInt(High - Low) + Low;
        GridCompOne[k][0] = Random;
        Random = r.nextInt(High - Low) + Low;
        GridCompOne[9][k] = Random;
        Random = r.nextInt(High - Low) + Low;
        GridCompOne[k][9] = Random;
        k++;
    }
    while (i <= 8) {
        while (j <= 8) {
            GridCompOne[i][j] = 3;
            j++;
        }
        j = 1;
        i++;
    }
}
}
class Spawner extends Grid
{
public static void RabbitWolfSpawner()
{
    Random r = new Random();

    int Low = 1;
    int High = 8;
    int XAxis;
    int YAxis;
    int Random;

    //Rabbit
    Random = r.nextInt(High - Low) + Low;
    XAxis = Random;
    Random = r.nextInt(High - Low) + Low;
    YAxis = Random;
    GridCompOne[XAxis][YAxis] = 4;
    Rabbit[0] = XAxis;
    Rabbit[1] = YAxis;
    //Wolf
    Random = r.nextInt(High - Low) + Low;
    XAxis = Random;
    Random = r.nextInt(High - Low) + Low;
    YAxis = Random;
    GridCompOne[XAxis][YAxis] = 5;
    Wolf[0] = XAxis;
    Wolf[1] = YAxis;
}
}
class Movement extends Grid
{
 private static int[][] GridCompTwo = new int[10][10];

public static void Copy()
{
    //System.arraycopy(GridCompOne, 0, GridCompTwo, 0, GridCompOne.length);
    //changed
    //As of my understanding System.arraycopy is not coping values , it is copying references 
    for(int i=0;i<GridCompOne.length;i++){
        for(int j=0;j<GridCompOne[i].length;j++){
            GridCompTwo[i][j]=GridCompOne[i][j];
        }
    }
}

//Rabbit and Wolf Movement

public static void Movement()
{

    int High = 4;
    int Low = 1;

    Random R = new Random();

    int Random = R.nextInt(High - Low) + Low;
    //Rabbit
    switch (Random)
    {
        case 1:
        {
            //Up
            GridCompOne[Rabbit[0]][Rabbit[1]] = GridCompTwo[Rabbit[0]][Rabbit[1]];
            GridCompOne[Rabbit[0] - 1][Rabbit[1]] = 4;
            Rabbit[0] = (Rabbit[0] - 1);
            break;
        }
        case 2:
        {
            //Down
            GridCompOne[Rabbit[0]][Rabbit[1]] = GridCompTwo[Rabbit[0]][Rabbit[1]];
            GridCompOne[Rabbit[0] + 1][Rabbit[1]] = 4;
            Rabbit[0] = (Rabbit[0] + 1);
            break;
        }
        case 3:
        {
            //Left
            GridCompOne[Rabbit[0]][Rabbit[1]] = GridCompTwo[Rabbit[0]][Rabbit[1]];
            GridCompOne[Rabbit[0]][Rabbit[1] - 1] = 4;
            Rabbit[1] = (Rabbit[1] - 1);
            break;
        }
        case 4:
        {
            //Right
            GridCompOne[Rabbit[0]][Rabbit[1]] = GridCompTwo[Rabbit[0]][Rabbit[1]];
            GridCompOne[Rabbit[0]][Rabbit[1] + 1] = 4;
            Rabbit[1] = (Rabbit[1] + 1);
            break;
        }
        default:
        {
            System.out.println("There was an error!!!");
            System.exit(0);
        }
    }
    Random = R.nextInt(High - Low) + Low;
    //Wolf
    switch (Random)
    {
        case 1: {
            //Up
            GridCompOne[Wolf[0]][Wolf[1]] = GridCompTwo[Wolf[0]][Wolf[1]];
            GridCompOne[Wolf[0] - 1][Wolf[1]] = 5;
            Wolf[0] = (Wolf[0] - 1);
            break;
        }
        case 2: {
            //Down
            GridCompOne[Wolf[0]][Wolf[1]] = GridCompTwo[Wolf[0]][Wolf[1]];
            GridCompOne[Wolf[0] + 1][Wolf[1]] = 5;
            Wolf[0] = (Wolf[0] + 1);
            break;
        }
        case 3: {
            //Left
            GridCompOne[Wolf[0]][Wolf[1]] = GridCompTwo[Wolf[0]][Wolf[1]];
            GridCompOne[Wolf[0]][Wolf[1] - 1] = 5;
            Wolf[1] = (Wolf[1] - 1);
            break;
        }
        case 4: {
            //Right
            GridCompOne[Wolf[0]][Wolf[1]] = GridCompTwo[Wolf[0]][Wolf[1]];
            GridCompOne[Wolf[0]][Wolf[1] + 1] = 5;
            Wolf[1] = (Wolf[1] + 1);
            break;
        }
        default: {
            System.out.println("There was an error!!!");
            System.exit(0);
        }
    }
}
}
class Display extends Movement
{
private static char[][] GridUser = new char[10][10];
public static void UserGrid()
{
    int i = 0;
    int j = 0;
    char Letter = ' ';

    System.out.println("---------------------");

    while (i <= 9)
    {
        while (j <= 9)
        {
            System.out.print("|");
            switch (GridCompOne[i][j])
            {
                case 1:
                {
                    //Water
                    Letter = '~';
                    break;
                }
                case 2:
                {
                    //Bridge
                    Letter = '=';
                    break;
                }
                case 3:
                {
                    //Ground
                    Letter = ',';
                    break;
                }
                case 4:
                {
                    //Rabbit
                    Letter = 'R';
                    break;
                }
                case 5:
                {
                    //Wolf
                    Letter = 'W';
                    break;
                }
                default:
                {
                    //Error!!!
                    System.out.println("There was an error in the program!!!");
                    System.exit(0);
                }
            }
            GridUser[i][j] = Letter;
            System.out.print(GridUser[i][j]);
            j++;
        }
        System.out.print("|");
        System.out.println();
        System.out.println("---------------------");
        j = 0;
        i++;
    }
}
}
class Logic extends Grid
{
public static int WinLose(int counter)
{

    int winlose = (0);
    if(GridCompOne[Rabbit[0]][Rabbit[1]]==1)
    {
        System.out.println("The Rabbit has drowned!");
        System.out.println("Game over!");
        Score.Lose = Score.Lose + 1;
        winlose = 3;
    }
    else if(GridCompOne[Rabbit[0]][Rabbit[1]]==2)
    {
        System.out.println("The Rabbit has Escaped!");
        System.out.println("Game over!");
        Score.Win = Score.Win + 1;
        winlose = 3;

    }
    else if(GridCompOne[Rabbit[0]][Rabbit[1]]==5)
    {
        System.out.println("The Rabbit has been Eaten by the Wolf!");
        System.out.println("Game over!");
        Score.Lose = Score.Lose + 1;
        winlose = 3;
    }
    else if(counter>30)
    {
        System.out.println("The Rabbit has starved to death");
        System.out.println("Game over!");
        Score.Lose = Score.Lose + 1;
        winlose = 3;
    }
        else
    {
        System.out.println(" (Next Turn in a couple seconds)");
    }
    return winlose;
}
}
class Time
{
public static void Delay()
{
    try
    {
        long Seconds = (2000);
        Thread.sleep(Seconds);
    }
    catch (InterruptedException e)
    {
        System.out.println("...");
    }
}
}