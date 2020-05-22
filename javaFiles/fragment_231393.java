public class Test {
    public static void main(String args[]){
        String str;
        System.out.println("Enter the String: ");
        Scanner s = new Scanner(System.in);
        str=s.nextLine();
        int count = 0;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i) == ' '){
                System.out.println("Space is at index =" + i ); 
                count++;
            }

        }
        System.out.println("The total number of space is: " + count);
    }
}