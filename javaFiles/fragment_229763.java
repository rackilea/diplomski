package coinsproblembfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Kassem M. Bagher
 */
public class BFS implements Runnable
{

    private LinkedList<Item> q;
    private List<Item> MoneyList;
    private double searchValue = 0;
    private long start = 0, end = 0;

    public BFS(List<Item> monyList, double searchValue, LinkedList<Item> queue)
    {
        q = new LinkedList<Item>();
        MoneyList = new ArrayList<Item>();
        this.searchValue = searchValue;
        for (int x = 0; x < queue.size(); x++)
        {
            q.addLast(queue.get(x));
        }
        for (int x = 0; x < monyList.size(); x++)
        {
            MoneyList.add(monyList.get(x));
        }
    }

    private synchronized void printPath(Item item)
    {

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

    private void addChildren(Item node, LinkedList<Item> q, boolean initialized)
    {
        for (int x = 0; x < MoneyList.size(); x++)
        {
            Item t = new Item();
            t.value = MoneyList.get(x).value;
            if (initialized)
            {
                t.Totalvalue = 0;
                t.level = 0;
            }
            else
            {
                t.parent = node;
                t.Totalvalue = MoneyList.get(x).Totalvalue;
                if (t.parent == null)
                {
                    t.level = 0;
                }
                else
                {
                    t.level = t.parent.level + 1;
                }
            }
            t.Title = MoneyList.get(x).Title;
            q.addLast(t);
        }
    }

    @Override
    public void run()
    {
        start = System.currentTimeMillis();
        try
        {
            while (!q.isEmpty())
            {
                Item node = null;
                node = (Item) q.removeFirst();
                node.Totalvalue = node.value + node.parent.Totalvalue;
                if (node.level < CoinsProblemBFS.searchLevelLimit)
                {
                    if (node.Totalvalue == searchValue)
                    {
                        synchronized (CoinsProblemBFS.lockLevelLimitation)
                        {
                            CoinsProblemBFS.searchLevelLimit = node.level;
                            CoinsProblemBFS.lastFoundNode = node;
                            end = System.currentTimeMillis();
                            CoinsProblemBFS.lastFoundNode.searchTime = (end - start);
                            CoinsProblemBFS.lastFoundNode.winnerThreadName=Thread.currentThread().getName();
                        }
                    }
                    else
                    {
                        if (node.level + 1 < CoinsProblemBFS.searchLevelLimit)
                        {
                            addChildren(node, q, false);
                        }
                    }
                }
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}