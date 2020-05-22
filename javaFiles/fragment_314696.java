public class Combo {
    public static void main(String[] args) {
        int[] A1 = { 1, 2, 3, 4 };
        int[] A2 = { 4, 3, 2, 1 };
        List<Combo> comboList = new ArrayList<>();
        for (int start = 0; start < A1.length; start++)
            for (int end = start; end < A1.length; end++) {
                final int combinations = 1 << ((end - start + 1) << 1); // 4 ^ (end - start + 1)
                for (int combo = 0; combo < combinations; combo++)
                    comboList.add(new Combo(start, end, combo));
            }
        Collections.sort(comboList, (c1, c2) -> Integer.compare(c1.end - c1.start, c2.end - c2.start));
        for (int i = 0; i < comboList.size(); i++) {
            Combo combo = comboList.get(i);
            System.out.printf("%3d: %-33s = %-17s = %d%n", i + 1, combo.getTextFormula(),
                              combo.getNumberFormula(A1, A2), combo.getSum(A1, A2));
        }
    }
    private final int start;
    private final int end;
    private final int combo;
    public Combo(int start, int end, int combo) {
        this.start = start;
        this.end = end;
        this.combo = combo;
    }
    private String getTextFormula() {
        StringBuilder buf = new StringBuilder();
        for (int i = this.start; i <= this.end; i++) {
            int c = this.combo >> ((this.end - i) << 1) & 3;
            if (i != this.start) buf.append(" + ");
            buf.append(c == 0 ? "A1" : c == 1 ? "-A1" : c == 2 ? "A2" : "-A2").append('[').append(i).append(']');
        }
        return buf.toString();
    }
    private String getNumberFormula(int[] A1, int[] A2) {
        StringBuilder buf = new StringBuilder();
        for (int i = this.start; i <= this.end; i++) {
            int c = this.combo >> ((this.end - i) << 1) & 3;
            if (i != this.start) buf.append(" + ");
            buf.append(c == 0 ? A1[i] : c == 1 ? -A1[i] : c == 2 ? A2[i] : -A2[i]);
        }
        return buf.toString();
    }
    private int getSum(int[] A1, int[] A2) {
        int sum = 0;
        for (int i = this.start; i <= this.end; i++) {
            int c = this.combo >> ((this.end - i) << 1) & 3;
            sum += (c == 0 ? A1[i] : c == 1 ? -A1[i] : c == 2 ? A2[i] : -A2[i]);
        }
        return sum;
    }
}