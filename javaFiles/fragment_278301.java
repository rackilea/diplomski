public class lists {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("How many things you have?");
        int size=input.nextInt();
        LinkedList<String> list= new LinkedList<String>();
        System.out.println("Enter those things");
        for(int c=0 ;c < size; c++)
        {
            String s = input.next();//use next() instead of nextLine()
            list.add(s);     
        }
            System.out.printf("%s",list);

       } 
    }