public class Recursion {

    public static void main(String[] args) {
        final Integer count = 9;
        final Recursion recursion = new Recursion(count);
        recursion.addLineAndReverse();
    }

    public Recursion(final Integer count) {
        this.count = count;
    }

    private final int count;

    public String printPattern(final int lineNumber) {

        String line= "";

        for(int i = 1; i <= count; ++i){
            if (i >= lineNumber) {
                line += i;
            } else {
                line += "*";
            }
        }
        line += reverseLine(lineNumber);
        return line;
    }

    public String reverseLine(final int lineNumber)
    {

        String line= "";

        for(int i = count; i >= 1; --i){
            if (i >= lineNumber) {
                line += i;
            } else {
                line += "*";
            }
        }

        return line;
    }

    public void addLineAndReverse(){
        for (int i = 1;  i <= count + 1; ++i){
            System.out.println(printPattern(i));
        }

    }

}