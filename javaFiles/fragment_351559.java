public class tmp {

    public static void main(String[] args) {
        String input = "1,2, 3, 4\n5, 6, 7\n\n,8"; //what we would read from file
        input = input.replace("\n"," "); //simulate removing newlines, ignore this
        String[] items = input.split("[, ]+"); //regex split
        for(String one : items) {
            System.out.println(one);
        }
    }

}