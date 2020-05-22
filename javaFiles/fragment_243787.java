public class BallTester {
    public static void main(String[] args)
    {        
        int speed;
        Scanner scanner = new Scanner(System.in);
        string s = scanner.next();
        try {            
            speed = Integer.parseInt(s);
            if (speed > 0) {
                ball(new Ball(5));
            }            
        }
        catch (NumberFormatException ex) {
             System.out.println("This is not a valid speed.");
        }
    }
}