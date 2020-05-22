public class Main {
    public static void main(String[] args) {
        //Both Squares
        StringBuilder filledLine = new StringBuilder(10);
        StringBuilder hollowLine = new StringBuilder(10);
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 10; j++) {
                filledLine.append("*");
                if (i == 1 || i == 5 || j == 1 || j == 10) {
                    hollowLine.append("*");
                } else {
                    hollowLine.append(" ");
                }
            }
            System.out.println(filledLine + " " + hollowLine);
            filledLine.delete(0, filledLine.length());
            hollowLine.delete(0, hollowLine.length());
        }
    }

}