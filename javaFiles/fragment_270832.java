public class Election {
    static String line;
    public static int highestLocation(int[] x){
        int max = 0, value = 0;
        for (int i=0; i<x.length; i++){
            if (x[i] > max){
                max = x[i];
                value = i;
            }
        }
        return value;
    }
    public static void main(String[] args) throws IOException {

        PriorityQueue<Integer> listpeople = new PriorityQueue<Integer>();

        FileReader file = new FileReader("C:\\votes.txt");

        BufferedReader in = new BufferedReader(file);

        while ((line = in.readLine()) != null) {
            int a = Integer.parseInt(line);
            listpeople.add(a);
        }
        in.close();
        int[] candidates = new int[24];
        for (int i = 0; i <= listpeople.size(); i++) {
            int x = listpeople.poll();
            candidates[x-1]++;
        }
        for (int i = 0; i < 9; i++) {
            int next = highestLocation(candidates);
            System.out.println((next+1) + " " + candidates[next]);
            candidates[next] = 0;
        }
    }
 }