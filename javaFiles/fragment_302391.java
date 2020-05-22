public class Example {
    public static void main(String args[] ) throws Exception {
        List<String> list = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while(true) {
            line = br.readLine();
            if (line == null || line.isEmpty()) {
                break;
            }
            list.add(line);
        }
        System.out.println(list);
    }
}