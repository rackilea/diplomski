public class Main {
    public static void main(String[] args) {
        String text = "text/numbers mix\n"+
                "numbers\n"+
                "numbers\n"+
                "text/numbers mix\n"+
                "numbers\n"+
                "numbers\n"+
                "numbers";
        String regex = "(?=text/numbers)";
        Scanner scan = new Scanner(text).useDelimiter(regex);
        while(scan.hasNext()) {
            System.out.println("------------------------");
            System.out.println(">"+scan.next().trim()+"<");
        }
    }
}