import java.util.Stack;
import java.util.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sandeep
 */
public class Main {
    static Stack stack=new Stack();
    static Stack stackT=new Stack();
    //static Vector v=new Vector();
    //static StringBuffer p=new StringBuffer();

    public static Stack toPostfix(String q)
{

    for(int i=0;i<q.length();i++)
    {   
        if(q.charAt(i)=='0'||q.charAt(i)=='1'||q.charAt(i)=='2'||q.charAt(i)=='3'||q.charAt(i)=='4'||q.charAt(i)=='5'||q.charAt(i)=='6'||q.charAt(i)=='7'||q.charAt(i)=='8'||q.charAt(i)=='9')
        {
            StringBuffer p=new StringBuffer();
            while(q.charAt(i)=='0'||q.charAt(i)=='1'||q.charAt(i)=='2'||q.charAt(i)=='3'||q.charAt(i)=='4'||q.charAt(i)=='5'||q.charAt(i)=='6'||q.charAt(i)=='7'||q.charAt(i)=='8'||q.charAt(i)=='9')
                    p.append(q.charAt(i++));
            stackT.push(p);
            i--;
        }
        else if(q.charAt(i)=='(')
        {
             stack.push(q.charAt(i));
        }
        else if(q.charAt(i)==')')
        {
            for(int j=0;!stack.empty()&&!stack.peek().equals('(');j++)
            {
                stackT.push(stack.pop().toString());
            }
            stack.pop();
        }
        else if(q.charAt(i)=='+'||q.charAt(i)=='-'||q.charAt(i)=='/'||q.charAt(i)=='*')
        {
            if(stack.empty()||stack.peek().equals('('))
                stack.push(q.charAt(i));
            else
            {
                while(!stack.empty()&&!stack.peek().equals('(')&&isHigh(q.charAt(i), stack.peek()))
                {
                    stackT.push(stack.pop().toString());
                }
                stack.push(q.charAt(i));
            }
        }
    }
   while(!stack.empty())
    {
        stackT.push(stack.pop().toString());
    }

       System.out.println(stackT);
    return stackT;
}

//problem lies here
public static boolean isHigh(char op, Object AtStack)
{
    char opAtStack=AtStack.toString().charAt(0);
    boolean isHigh=false;
    if((op==opAtStack))
        isHigh=true;
    if((op=='+'||op=='-')&&(opAtStack=='/'||opAtStack=='*'))
    {
        isHigh=true;
    }
    if((op=='+'&&opAtStack=='-')||(op=='-'&&opAtStack=='+')||(op=='/'&&opAtStack=='*')||(op=='*'&&opAtStack=='/'))
    {
        isHigh=true;
    }
        return isHigh;
}

public static double result(Stack p)
{

    for(int i=0;i<p.size();i++)
    {   
        if(p.get(i).toString().startsWith("0")||p.get(i).toString().startsWith("1")||p.get(i).toString().startsWith("2")||p.get(i).toString().startsWith("3")||p.get(i).toString().startsWith("4")||p.get(i).toString().startsWith("5")||p.get(i).toString().startsWith("6")||p.get(i).toString().startsWith("7")||p.get(i).toString().startsWith("8")||p.get(i).toString().startsWith("9"))
        {
            stack.push(p.get(i));
        }
        if(p.get(i).toString().equals("+")||p.get(i).toString().equals("-")||p.get(i).toString().equals("/")||p.get(i).toString().equals("*"))
        {
            double a=Double.parseDouble(stack.pop().toString());
            double b=Double.parseDouble(stack.pop().toString());
            if(p.get(i).equals("+"))
            {
                stack.push(b+a);
            }
            else if(p.get(i).equals("-"))
            {
                stack.push(b-a);
            }
            else if(p.get(i).equals("/"))
            {
                stack.push(b/a);
            }
            else if(p.get(i).equals("*"))
            {
                stack.push(b*a);
            }
        }
    }
    System.out.println(stack);
    return 0;
}

public static void main(String[] args) {
        // TODO code application logic here
        String s=new String("159*(79+23)-10/4+(22*54-67*(25*58))");
        Main.result(Main.toPostfix(s));
        System.out.println(159*(79+23)-10/4+(22*54-67*(25*58)));
    }
}