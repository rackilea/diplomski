public class Testing {
private int val1; 
private int val2;
private int res;

public static void main(String[] args)
{
    new Testing();
}

public Testing()
{
    this.val1 = 4;
    this.val2 = 8;
    this.res = 0;
    this.calcResult();
}

public int calcResult()
{
    res = this.val1 + this.val2;
    return res;
}
}