public class negnum {
    public static void main(String [] args) {

    ArrayList<Integer> nums = new ArrayList();
    nums.add(0);
    nums.add(10);
    nums.add(-10);
    nums.add(20);
    nums.add(-20);
    nums.add(30);
    nums.add(-30);
    nums.add(40);
    nums.add(-40);
    nums.add(50);   

    int negs = 0;
    for (int i = 0; i < nums.size(); i++){
        int n = nums.get(i);
        if (n < 0) {
            ++negs;
            System.out.println(n);
        }        
    }
    System.out.println(negs +" negatives");  
    }
}

c:\dev>java negnum
-10
-20
-30
-40
4 negatives