public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(Arrays.toString(test.A1));
        System.out.println(Arrays.toString(test.A2));
        System.out.println(test.result);
    }
    private int[] A1, A2;
    private List<Integer> result;
    private Test() {
        List<Integer> digits = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        Random random = new Random();
        this.A1 = new int[4];
        for (int i = 0; i < this.A1.length; i++) {
            int idx = random.nextInt(digits.size());
            this.A1[i] = digits.remove(idx);
        }
        Arrays.sort(this.A1);

        this.A2 = new int[this.A1.length];
        for (int i = 0; i < this.A1.length; i++)
            this.A2[i] = this.A1[this.A1.length - i - 1];

        this.result = new ArrayList<>();
        for (int i = 0; i < this.A1.length; i++)
            calc(i, 0);
    }
    private void calc(int idx, int sum) {
        add(sum + this.A1[idx], idx + 1);
        add(sum - this.A1[idx], idx + 1);
        add(sum + this.A2[idx], idx + 1);
        add(sum - this.A2[idx], idx + 1);
    }
    private void add(int sum, int nextIdx) {
        this.result.add(sum);
        if (nextIdx < this.A1.length)
            calc(nextIdx, sum);
    }
}