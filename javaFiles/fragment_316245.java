public class Testing_Code
{
    static boolean inRange(char c, char first, char last) {
        return (c >= first) && (c <= last);
    }

    public static void main(String[] args)
    {
        Scanner userInput = new Scanner (System.in);
        String refNum;

        System.out.println("Enter refNum: example - WE123A");
        refNum = userInput.next();

        while(refnum.length() != 6 
                || !inRange(refnum.charAt(0), 'A', 'Z') 
                || !inRange(refnum.charAt(1), 'A', 'Z') 
                || !inRange(refnum.charAt(2), '0', '9') 
                || !inRange(refnum.charAt(3), '0', '9') 
                || !inRange(refnum.charAt(4), '0', '9') 
                || !inRange(refnum.charAt(5), 'A', 'Z'))
        {
            System.out.println("Invalid reference number. Try again.\n ");
            System.out.println("Please enter reference No.:  ");
            refNum = userInput.next();
            rnLength = refNum.length();
        }
    }
}