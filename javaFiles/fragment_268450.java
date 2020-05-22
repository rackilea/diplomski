public class MyClass {     
    public static void main(String[] args) {    
        Scanner input=new Scanner(System.in);    
        ArrayList<Integer> myList=new ArrayList<Integer>(10);    
        System.out.println("Enter your number:");
        int n = input.nextInt();
        myList.add(n);
        myList.add(416355);    
        myList.add(21212);    
        for(int x : myList)    
            System.out.println(x);    
        System.out.println("Size="+myList.size());    

    } 
  }