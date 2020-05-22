import java.util.Random;
import java.util.ArrayList;
class seq
{
    private ArrayList<Integer> arrListOne;
    private ArrayList<Integer> arrListTwo;
    private Random num;

    public seq()
    {
        num = new Random();
        arrListOne = new ArrayList<Integer>();
        arrListTwo = new ArrayList<Integer>();
        getFillerArr();
        randNewArr();
    }

    // You dont have to return ArrayList here
    public void getFilledArr()
    {
        for(int i = 1; i < 11 ; i++)
        {
            arrListOne.add(i);
        }
    }

    // You dont have to return ArrayList here
    public void randNewArr()
    {
        for(int i = 0 ; i < 10 ; i++)
        {
            int randNum = num.nextInt(arrListOne.size())+1;
            arrListTwo.add(arrListOne.get(randNum));
            arrListOne.remove(arrListOne.get(randNum));
        }
    }

    // A method that returns you random array list so you can easily use it following rules of encapsulation
    public ArrayList<Integer> getRandomArray() {
        return this.arrListTwo;
    }
}

public class Sequence
{
    public static void main(String[] args){
        seq seqObj = new seq();
        System.out.println(seq.getRandomArray());
    }
}