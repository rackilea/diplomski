import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberPuzzle
{
    public static void main(String[] args)
    {
        List<Integer> numbers = Arrays.asList(2,4,5,25,75,100); 
        Integer result = 268;
        solve(numbers, result);
    }

    private static void solve(List<Integer> numbers, Integer result)
    {
        List<Node> nodes = new ArrayList<Node>();
        for (int i=0; i<numbers.size(); i++)
        {
            Integer number = numbers.get(i);
            nodes.add(new Node(number));
        }
        System.out.println(nodes);


        List<Node> all = create(nodes);
        System.out.println("Found "+all.size()+" combinations");

        List<Node> best = new ArrayList<Node>();
        Integer minDifference = Integer.MAX_VALUE;
        for (Node n : all)
        {
            //System.out.println(n);
            Integer e = n.evaluate();
            Integer difference = Math.abs(e - result); 
            if (difference < minDifference)
            {
                best.clear();
                minDifference = difference;
                best.add(n);
            }
            else if (difference.equals(minDifference))
            {
                best.add(n);
            }
        }

        for (Node n : best)
        {
            System.out.println(n+" = "+n.evaluate());
        }
    }

    private static List<Node> create(List<Node> nodes)
    {
        if (nodes.size() == 1)
        {
            return nodes;
        }
        List<Node> result = new ArrayList<Node>(nodes);
        for (int i=0; i<nodes.size(); i++)
        {
            List<Node> copy = new ArrayList<Node>(nodes);
            Node node = copy.remove(i);
            List<Node> others = create(copy);
            for (int j=0; j<others.size(); j++)
            {
                Node other = others.get(j);
                result.add(new Node(node, '+', other));
                result.add(new Node(node, '*', other));
                result.add(new Node(node, '-', other));
                result.add(new Node(other, '-', node));

                Integer vNode = node.evaluate();
                Integer vOther = other.evaluate();
                if (vOther != 0 && vNode % vOther == 0)
                {
                    result.add(new Node(node, '/', other));
                }
                if (vNode != 0 && vOther % vNode == 0)
                {
                    result.add(new Node(other, '/', node));
                }
            }
        }
        return result;
    }

    static class Node
    {
        Integer value;
        Node left;
        Character op;
        Node right;

        Node(Node left, Character op, Node right)
        {
            this.left = left;
            this.op = op;
            this.right = right;
        }
        Node(Integer value)
        {
            this.value = value;
        }

        Integer evaluate()
        {
            if (op != null)
            {
                Integer lv = left.evaluate();
                Integer rv = right.evaluate();
                switch (op)
                {
                    case '+': return lv + rv;
                    case '-': return lv - rv;
                    case '*': return lv * rv;
                    case '/': return rv.equals(0) ? Integer.MAX_VALUE : lv / rv;
                }
            }
            return value;
        }

        @Override
        public String toString()
        {
            if (op == null)
            {
                return String.valueOf(value);
            }
            return "("+left.toString()+op+right.toString()+")";
        }
    }
}