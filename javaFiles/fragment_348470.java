public class number{
    private int sum;
    private String str;

    // CONSTRUCTOR
    public number(int sum, String str){
        this.sum=sum;
        this.str=str;
    }

    public void add(int sum2){
        sum+=sum2;
        if(!str.equals(""))
            str = str +" + "+ sum2;
        else if(str.equals(""))
            str = "" + sum2;
    }

    // ACCESSORS
    public String getStr() {
        return this.str;
    }

    public int getSum() {
        return this.sum;
    }

    // MODIFIERS
    public void setStr(String newStr) {
        this.str = newStr;
    }

    public void setSum(int newSum) {
        this.sum = newSum;
    }

}
// function to compute the minimum sum path
// It only returns the sum of the values of nodes on the min sum path 
number minSumPath(SolutionNode current) {
  number  tr1= new number(0,"");
    if(current == null){
        return tr1;
    }
    int sum = current.getValue();

    int left_sum = minSumPath(current.childLeft).sum;
    int right_sum = minSumPath(current.childRight).sum;

    if(left_sum <= right_sum) {
       tr1= minSumPath(current.childLeft);
        tr1.add(sum);
    }
    else {
        tr1= minSumPath(current.childLeft);
        tr1.add(sum);
       }
    return tr1;
}