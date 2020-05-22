import java.util.ArrayList;

class StackIsUnderflowing extends Exception
{

    private static final long serialVersionUID = 1L;

    public StackIsUnderflowing()
    {
        super("Stack Underflowing");
    }
}

//main Stack class
public class Stack
{
    private int index;
    //List of String literals
    private ArrayList<String> aStackArr = new ArrayList<String>();
    private static int ZERO = 0;

    //constructor
    public Stack()
    {
        this.index = -1;
    }

    //return the size
    public int size()
    {
        return aStackArr.size();
    }

    //push value on to Stack add value to List of String input variable
    public void push(String anInt)
    {
        aStackArr.add(anInt);
        index = aStackArr.size() - 1;
        System.out.println(index + aStackArr.get(index));
    }

    //pop values from input variable
    public String pop()
    {
        try
        {
            if (index < Stack.ZERO)
            {
                throw new StackIsUnderflowing();
            }
            else
            {
                String result = aStackArr.remove(index);
                index = aStackArr.size() - 1;
                return result;
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.exit(-1);
            return "-1";
        }
    }

    //peek into LIFO top input literal

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        Stack aStack = new Stack();
        String[] names = new String[3];
        names[0] = "ll";
        names[1] = "cc";
        names[2] = "dd";
        String tmp;

        for (int i = 0; i < names.length; ++i)
        {
            System.out.println(names[i]);
            aStack.push(names[i]);
        }
        tmp = aStack.pop();
        System.out.println(tmp);
    }
}