import  java.util.Arrays;
public class MoreArrayProblems
{
  public static final void main(String[] ignored)  {
     System.out.println(Arrays.toString(
        (new MoreArrayProblems()).everyOther(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10})));
  }
    public int[] everyOther (int [] a){
        if (a.length < 2){
        return a;

        }

        int []l = new int[a.length/2];
        //if (a.length%2==0) {int l[]= new int [a.length/2];}
        //else {l[] = int [a.length + 1 / 2];}

        int loc= 0, i = 1;
        while ( i<a.length){
System.out.println("l.length=" + l.length + ", a.length=" + a.length + ", i=" + i + ", [i - 1]=" + (i - 1) + "");
            l[i] = a[i-1];   //for some reason this doesn't work
            i += 2;

        }
        return l;
    }
}