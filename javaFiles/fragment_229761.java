package coinsproblembfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Kassem M. Bagher
 */
public class CoinsProblemBFS
{

    private static List<Item> MoneyList = new ArrayList<Item>();
    private static Queue<Item> q = new LinkedList<Item>();
    private static LinkedList<Item> tmpQ;
    public static Object lockLevelLimitation = new Object();
    public static int searchLevelLimit = 1000;
    public static Item lastFoundNode = null;
    private static int numberOfThreads = 2;

    private static void InitializeQueu(Item Root)
    {
        for (int x = 0; x < MoneyList.size(); x++)
        {
            Item t = new Item();
            t.value = MoneyList.get(x).value;
            t.Totalvalue = MoneyList.get(x).Totalvalue;
            t.Title = MoneyList.get(x).Title;
            t.parent = Root;
            t.level = 1;
            q.add(t);
        }
    }

    private static int[] calculateQueueLimit(int numberOfItems, int numberOfThreads)
    {
        int total = 0;
        int[] queueLimit = new int[numberOfThreads];

        for (int x = 0; x < numberOfItems; x++)
        {
            if (total < numberOfItems)
            {
                queueLimit[x % numberOfThreads] += 1;
                total++;
            }
            else
            {
                break;
            }
        }
        return queueLimit;
    }

    private static void initializeMoneyList(int numberOfItems, Item Root)
    {
        for (int x = 0; x < numberOfItems; x++)
        {
            Scanner input = new Scanner(System.in);
            Item t = new Item();
            System.out.print("Enter the Title and Value for item " + (x + 1) + ": ");
            String tmp = input.nextLine();
            t.Title = tmp.split(" ")[0];
            t.value = Double.parseDouble(tmp.split(" ")[1]);
            t.Totalvalue = t.value;
            t.parent = Root;
            MoneyList.add(t);
        }
    }

    private static void printPath(Item item)
    {
        System.out.println("\nSolution Found in Thread:" + item.winnerThreadName + "\nExecution Time: " + item.searchTime + " ms, " + (item.searchTime / 1000) + " s");
        while (item != null)
        {
            for (Item listItem : MoneyList)
            {
                if (listItem.Title.equals(item.Title))
                {
                    listItem.counter++;
                }
            }
            item = item.parent;
        }
        for (Item listItem : MoneyList)
        {
            System.out.println(listItem.Title + " x " + listItem.counter);
        }

    }

    public static void main(String[] args) throws InterruptedException
    {
        Item Root = new Item();
        Root.Title = "Root Node";
        Scanner input = new Scanner(System.in);
        System.out.print("Number of Items: ");
        int numberOfItems = input.nextInt();
        input.nextLine();

        initializeMoneyList(numberOfItems, Root);


        System.out.print("Enter the Amount of Money: ");
        double searchValue = input.nextDouble();
        int searchLimit = (int) Math.ceil((searchValue / MoneyList.get(MoneyList.size() - 1).value));
        System.out.print("Number of Threads (Muste be less than the number of items): ");
        numberOfThreads = input.nextInt();

        if (numberOfThreads > numberOfItems)
        {
            System.exit(1);
        }

        InitializeQueu(Root);

        int[] queueLimit = calculateQueueLimit(numberOfItems, numberOfThreads);
        List<Thread> threadList = new ArrayList<Thread>();

        for (int x = 0; x < numberOfThreads; x++)
        {
            tmpQ = new LinkedList<Item>();
            for (int y = 0; y < queueLimit[x]; y++)
            {
                tmpQ.add(q.remove());
            }
            BFS tmpThreadObject = new BFS(MoneyList, searchValue, tmpQ);
            Thread t = new Thread(tmpThreadObject);
            t.setName((x + 1) + "");
            threadList.add(t);
        }

        for (Thread t : threadList)
        {
            t.start();
        }

        boolean finish = false;

        while (!finish)
        {
            Thread.sleep(250);
            for (Thread t : threadList)
            {
                if (t.isAlive())
                {
                    finish = false;
                    break;
                }
                else
                {
                    finish = true;
                }
            }
        }
        printPath(lastFoundNode);

    }
}