public class CalcClass{
    public double calcPrice(String[] a, int[] qty, int num){
        int i =0;
        for(i=0;i<=num;i++) { 
            if ("a".equals(a[i]))
               price=24.90;
        }

        double tot=price+qty[i];
        return tot;
    }
}

public class MainClass{
    public static void main(String[] args){
        //create instance of calc class
        CalcClass c = new CalcClass();
        //call calc price method on calcclass
        c.calcPrice(a, new int[]{1}, 1};
    }
}