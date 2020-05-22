public class division {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine(); //reads a line from the console (user has to enter with keyboard and then push [ENTER])
        int end = s.indexOf(' '); //finds the index of the first space and writes it into "end"
        int n = Integer.parseInt(s.substring(0, end)); //parses an int from the given user input. stops at the first space (because of "end")
        int k = Integer.parseInt(s.substring(end + 1)); //parses an int from the given user input. starts after the first space (because of "end")

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(br.readLine()) % k == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}